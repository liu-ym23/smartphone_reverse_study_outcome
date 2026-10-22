package com.larus.uaigc.chat.markdown.image;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.k0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.bmhome.chat.layout.widget.n0;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.message.Message;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.service.m3;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.impl.databinding.LarusItemMarkdownCreationImageScrollBinding;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003123BÓ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u001e\u0010\u0015\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0013\u00122\u0010\u0019\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010%\u001a\u00020\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0!J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\u0018\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0014H\u0016J&\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00142\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001800H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR<\u0010\u0019\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR*\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00064"}, d2 = {"Lcom/larus/uaigc/chat/markdown/image/MDImageScrollAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/uaigc/chat/markdown/image/MDImageScrollAdapter$MDImageScrollViewHolder;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "imageEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "videoEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "modelProviderGetter", "Lkotlin/Function0;", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "clickListener", "Lkotlin/Function2;", "Lcom/larus/uaigc/chat/markdown/bean/GenImageViewData;", "Landroid/view/View;", "", "longClickListenerBinder", "onExpose", "Lkotlin/Function1;", "", "messageGetter", "Lkotlin/coroutines/Continuation;", "Lcom/larus/im/bean/message/Message;", "", "commonParamGetter", "", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "value", "", "dataList", "getDataList", "()Ljava/util/List;", "refreshData", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "payloads", "", "DiffCallback", "MDImageScrollViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MDImageScrollAdapter extends RecyclerView.Adapter<MDImageScrollViewHolder> {
    public static final /* synthetic */ int k = 0;
    public final CoroutineScope a;
    public final com.larus.uaigc.chat.markdown.image.component.a b;
    public final com.larus.uaigc.chat.markdown.image.component.k c;
    public final Function0<q0.a> d;
    public final Function2<fz9.c, View, Unit> e;
    public final Function2<fz9.c, View, Unit> f;
    public final Function1<Integer, Unit> g;
    public final Function1<Continuation<? super Message>, Object> h;
    public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> i;
    public List<? extends fz9.c> j;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/chat/markdown/image/MDImageScrollAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/uaigc/chat/markdown/bean/GenImageViewData;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<fz9.c> a;
        public final List<fz9.c> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DiffCallback(List<? extends fz9.c> r2, List<? extends fz9.c> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r6, int r7) {
            fz9.c r8 = (fz9.c) ListProtector.get(this.a, r6);
            fz9.c r9 = (fz9.c) ListProtector.get(this.b, r7);
            if ((r8 instanceof fz9.e) == false) goto L14;
            if ((r9 instanceof fz9.e) == false) goto L14;
            fz9.e r10 = (fz9.e) r8;
            fz9.e r11 = (fz9.e) r9;
            if (r10.c == r11.c) goto L9;
        L11:
            return false;
        L9:
            if (r10.b != r11.b) goto L11;
            return true;
        L14:
            if ((r8 instanceof fz9.d) == true) goto L16;
        L56:
            return false;
        L16:
            if ((r9 instanceof fz9.d) == false) goto L56;
            fz9.d r12 = (fz9.d) r8;
            ImageInfo r0 = r12.f;
            String r3 = null;
            if (r0 == null) goto L21;
            String r1 = r0.e;
        L22:
            fz9.d r13 = (fz9.d) r9;
            ImageInfo r4 = r13.f;
            if (r4 == null) goto L25;
            String r5 = r4.e;
        L27:
            if (Intrinsics.areEqual(r1, r5) == false) goto L54;
            ImageInfo r2 = r12.f;
            if (r2 == null) goto L33;
            Image r14 = r2.b;
            if (r14 == null) goto L33;
            String r15 = r14.a;
        L34:
            ImageInfo r16 = r13.f;
            if (r16 == null) goto L40;
            Image r17 = r16.b;
            if (r17 == null) goto L40;
            r3 = r17.a;
        L40:
            if (Intrinsics.areEqual(r15, r3) == false) goto L54;
            if (r12.c != r13.c) goto L54;
            if (r12.b != r13.b) goto L54;
            if (r12.g != r13.g) goto L54;
            if (r12.h != r13.h) goto L54;
            if (r12.i != r13.i) goto L54;
            if (r12.j != r13.j) goto L54;
            return true;
        L33:
            r15 = null;
        L54:
            return false;
        L25:
            r5 = null;
            goto L27
        L21:
            r1 = null;
            goto L22
        }

        public final boolean areItemsTheSame(int r2, int r3) {
            return Intrinsics.areEqual(((fz9.c) ListProtector.get(this.a, r2)).getTaskId(), ((fz9.c) ListProtector.get(this.b, r3)).getTaskId());
        }

        public final Object getChangePayload(int r5, int r6) {
            fz9.c r7 = (fz9.c) ListProtector.get(this.a, r5);
            fz9.c r8 = (fz9.c) ListProtector.get(this.b, r6);
            if ((r7 instanceof fz9.e) == false) goto L7;
            if ((r8 instanceof fz9.e) == false) goto L7;
        L33:
            return new o(r8.getWidth(), r8.getHeight());
        L7:
            if ((r7 instanceof fz9.d) == true) goto L9;
        L34:
            return null;
        L9:
            if ((r8 instanceof fz9.d) == false) goto L34;
            fz9.d r9 = (fz9.d) r7;
            ImageInfo r0 = r9.f;
            if (r0 == null) goto L15;
            Image r1 = r0.b;
            if (r1 == null) goto L15;
            String r2 = r1.a;
        L16:
            fz9.d r3 = (fz9.d) r8;
            ImageInfo r4 = r3.f;
            if (r4 == null) goto L21;
            Image r10 = r4.b;
            if (r10 == null) goto L21;
            String r11 = r10.a;
        L23:
            if (Intrinsics.areEqual(r2, r11) == false) goto L34;
            if (r9.g != r3.g) goto L34;
            if (r9.h != r3.h) goto L34;
            if (r9.i != r3.i) goto L34;
            if (r9.j != r3.j) goto L34;
        L21:
            r11 = null;
        L15:
            r2 = null;
            goto L16
        }
    }

    @Metadata(d1 = {"\u0000Á\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001C\u0018\u0000 `2\u00020\u0001:\u0002_`B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u001e\u0010\r\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e\u00122\u0010\u0012\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00140\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u0002052\u0006\u0010J\u001a\u000209J\u0016\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u0002092\u0006\u0010M\u001a\u000209J\b\u0010N\u001a\u00020HH\u0002J\u0018\u0010O\u001a\u00020H2\u0006\u0010I\u001a\u00020P2\u0006\u0010Q\u001a\u00020>H\u0002J\u001a\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010L\u001a\u0002092\u0006\u0010M\u001a\u000209H\u0002J\u0010\u0010T\u001a\u00020H2\u0006\u0010I\u001a\u00020UH\u0002J\u0016\u0010V\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020Y\u0018\u00010X0WH\u0002J\u0012\u0010Z\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010PH\u0002J\u0010\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020PH\u0002J\u0012\u0010]\u001a\u00020H2\b\u0010\\\u001a\u0004\u0018\u00010PH\u0002J\u0012\u0010^\u001a\u00020H2\b\u0010\\\u001a\u0004\u0018\u00010PH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R<\u0010\u0012\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00140\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u001f\u001a\u0004\b1\u00102R\"\u00106\u001a\u0004\u0018\u0001052\b\u00104\u001a\u0004\u0018\u000105@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001092\b\u00104\u001a\u0004\u0018\u000109@BX\u0086\u000e¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u001e\u0010?\u001a\u00020>2\u0006\u00104\u001a\u00020>@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u001f\u001a\u0004\bD\u0010E¨\u0006a"}, d2 = {"Lcom/larus/uaigc/chat/markdown/image/MDImageScrollAdapter$MDImageScrollViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusItemMarkdownCreationImageScrollBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "imageEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "videoEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "modelProviderGetter", "Lkotlin/Function0;", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "messageGetter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/larus/im/bean/message/Message;", "", "commonParamGetter", "Lkotlin/Function2;", "", "", "<init>", "(Lcom/larus/uaigc/impl/databinding/LarusItemMarkdownCreationImageScrollBinding;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "loadingProgressComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageLoadingProgressComponent;", "getLoadingProgressComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageLoadingProgressComponent;", "loadingProgressComponent$delegate", "Lkotlin/Lazy;", "loadImageComponent", "Lcom/larus/uaigc/chat/markdown/image/component/LoadImageComponent;", "getLoadImageComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/LoadImageComponent;", "loadImageComponent$delegate", "imageOperatorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageOperatorComponent;", "getImageOperatorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageOperatorComponent;", "imageOperatorComponent$delegate", "imageEditorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorComponent;", "getImageEditorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorComponent;", "imageEditorComponent$delegate", "videoEditorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorComponent;", "getVideoEditorComponent", "()Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorComponent;", "videoEditorComponent$delegate", "value", "Lcom/larus/uaigc/chat/markdown/bean/GenImageViewData;", "curBindData", "getCurBindData", "()Lcom/larus/uaigc/chat/markdown/bean/GenImageViewData;", "", "curPosition", "getCurPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "", "isLoadImageFailed", "()Z", "hasRefreshButtons", "imageLoadControllerListener", "com/larus/uaigc/chat/markdown/image/MDImageScrollAdapter$MDImageScrollViewHolder$imageLoadControllerListener$2$1", "getImageLoadControllerListener", "()Lcom/larus/uaigc/chat/markdown/image/MDImageScrollAdapter$MDImageScrollViewHolder$imageLoadControllerListener$2$1;", "imageLoadControllerListener$delegate", "bindData", "", "data", "position", "refreshSize", "width", "height", "refreshButtons", "showGeneratedImage", "Lcom/larus/uaigc/chat/markdown/bean/ImageItemData;", "isPreLoading", "buildContainerResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "showProgressLoading", "Lcom/larus/uaigc/chat/markdown/bean/ProgressLoadingData;", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "refreshTips", "initShareDownloadClickAction", "imageData", "refreshImageEditBtn", "refreshShareOrDownloadBtn", "Payload", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class MDImageScrollViewHolder extends RecyclerView.ViewHolder {
        public static final Lazy<hy9.d> r = null;
        public final LarusItemMarkdownCreationImageScrollBinding a;
        public final CoroutineScope b;
        public final com.larus.uaigc.chat.markdown.image.component.a c;
        public final com.larus.uaigc.chat.markdown.image.component.k d;
        public final Function0<q0.a> e;
        public final Function1<Continuation<? super Message>, Object> f;
        public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> g;
        public final Lazy h;
        public final Lazy i;
        public final Lazy j;
        public final Lazy k;
        public final Lazy l;
        public fz9.c m;
        public Integer n;
        public boolean o;
        public boolean p;
        public final Lazy q;

        public static final class a {
            public static hy9.d a() {
                return (hy9.d) MDImageScrollViewHolder.r.getValue();
            }
        }

        public static final class b extends BaseControllerListener<com.facebook.imagepipeline.image.ImageInfo> {
            public final /* synthetic */ MDImageScrollViewHolder a;

            public b(MDImageScrollViewHolder r1) {
                this.a = r1;
            }

            public final void onFailure(String r1, Throwable r2) {
                super.onFailure(r1, r2);
                this.a.a.j.setAlpha(1.0f);
                ((com.larus.uaigc.chat.markdown.image.component.c) this.a.h.getValue()).a(null, null);
                this.a.o = true;
            }

            public final void onIntermediateImageSet(String r2, Object r3) {
                MDImageScrollViewHolder.T3(this.a);
                super.onIntermediateImageSet(r2, (com.facebook.imagepipeline.image.ImageInfo) r3);
            }

            public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
                this.a.a.j.setAlpha(1.0f);
                ((com.larus.uaigc.chat.markdown.image.component.c) this.a.h.getValue()).a(null, null);
                super.onFinalImageSet(r3, (com.facebook.imagepipeline.image.ImageInfo) r4, r5);
                MDImageScrollViewHolder.T3(this.a);
                this.a.o = false;
            }
        }

        public static final class c implements com.larus.uaigc.chat.markdown.image.component.d {
            public final View a;
            public final CoroutineScope b;
            public final Function1<Continuation<? super Message>, Object> c;
            public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> d;

            @Override // com.larus.uaigc.chat.markdown.image.component.d
            public final String getLogTag() {
                return "MDImageScrollViewHolder";
            }

            @Override // com.larus.uaigc.chat.markdown.image.component.d
            public final View a() {
                return this.a;
            }

            @Override // com.larus.uaigc.chat.markdown.image.component.d
            public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> b() {
                return this.d;
            }

            @Override // com.larus.uaigc.chat.markdown.image.component.d
            public final Function1<Continuation<? super Message>, Object> c() {
                return this.c;
            }

            public c(MDImageScrollViewHolder r2) {
                this.a = ((RecyclerView.ViewHolder) r2).itemView;
                this.b = r2.b;
                this.c = r2.f;
                this.d = r2.g;
            }
        }

        public static final class d implements com.larus.uaigc.chat.markdown.image.component.j {
            public final /* synthetic */ MDImageScrollViewHolder a;

            @Override // com.larus.uaigc.chat.markdown.image.component.j
            public final String getLogTag() {
                return "MDImageScrollViewHolder";
            }

            @Override // com.larus.uaigc.chat.markdown.image.component.j
            public final String a() {
                fz9.c r0 = this.a.m;
                if (r0 != null) goto L7;
                return null;
            L7:
                return r0.getTaskId();
            }

            @Override // com.larus.uaigc.chat.markdown.image.component.j
            public final Message b() {
                fz9.c r0 = this.a.m;
                if (r0 != null) goto L7;
                return null;
            L7:
                return r0.getMessage();
            }

            public d(MDImageScrollViewHolder r1) {
                this.a = r1;
            }
        }

        static {
            r = LazyKt.lazy(new e());
        }

        public static final void T3(final MDImageScrollViewHolder r27) {
            if (r27.p == false) goto L5;
            return;
        L5:
            if (r27.a.j.getAlpha() != 1.0f) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == false) goto L174;
            fz9.c r2 = r27.m;
            if ((r2 instanceof fz9.d) == false) goto L12;
            final fz9.d r3 = (fz9.d) r2;
        L13:
            if (r3 == null) goto L175;
            LarusItemMarkdownCreationImageScrollBinding r4 = r27.a;
            boolean r6 = r3.h;
            boolean r7 = r3.g;
            ImageView r8 = r4.g;
            int r9 = 8;
            if (r6 == false) goto L17;
            int r10 = 0;
        L18:
            r8.setVisibility(r10);
            ImageView r11 = r4.d;
            if (r7 == false) goto L21;
            int r12 = 0;
        L22:
            r11.setVisibility(r12);
            if (r7 == true) goto L30;
            if (r6 == false) goto L30;
            ImageView r13 = r4.g;
            ViewGroup.LayoutParams r14 = r13.getLayoutParams();
            if (r14 == null) goto L29;
            ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
            r15.setMarginStart(i5.Y());
            r13.setLayoutParams(r15);
        L33:
            if (r7 == false) goto L41;
            ImageInfo r16 = r3.f;
            if (r16 == null) goto L41;
            Image r17 = r16.a;
            if (r17 == null) goto L41;
            String r18 = r17.a;
            if (r18 == null) goto L41;
            BuildersKt.launch$default(r27.b, null, null, new MDImageScrollAdapter$MDImageScrollViewHolder$refreshShareOrDownloadBtn$1$3$1(r18, r4, null), 3, null);
        L41:
            LarusItemMarkdownCreationImageScrollBinding r5 = r27.a;
            e1.d(r5.g, new l(r27, r3));
            e1.d(r5.d, new m(r27, r3));
            ImageInfo r19 = r3.f;
            if (r19 == null) goto L51;
            String r20 = r19.g;
            if (r20 == null) goto L51;
            if (r20.length() <= 0) goto L48;
            boolean r21 = true;
        L49:
            if (r21 == false) goto L51;
            e1.x(r27.a.h);
            r27.a.i.setText(r20);
            goto L51
        L48:
            r21 = false;
        L51:
            LarusItemMarkdownCreationImageScrollBinding r22 = r27.a;
            ImageCoverEditView r23 = r22.c;
            if (r3.i == false) goto L54;
        L57:
            boolean r24 = true;
        L58:
            if (r24 == false) goto L60;
            r9 = 0;
        L60:
            r23.setVisibility(r9);
            if (r22.c.getVisibility() != 0) goto L63;
            boolean r25 = true;
        L64:
            if (r25 == false) goto L146;
            ImageView r26 = r22.g;
            ViewGroup.LayoutParams r28 = r26.getLayoutParams();
            if (r28 == null) goto L145;
            ConstraintLayout.LayoutParams r29 = (ConstraintLayout.LayoutParams) r28;
            r29.setMarginStart(i5.Y());
            r26.setLayoutParams(r29);
            r22.d.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
            r22.e.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
            r22.g.setBackground(ContextCompat.getDrawable(r27.a.a.getContext(), 2131239118));
            Message r30 = r3.d;
            if (r30 == null) goto L146;
            String r31 = r30.getMessageId();
            if (r31 == null) goto L146;
            q0.a r32 = (q0.a) r27.e.invoke();
            if (r32 == null) goto L76;
            u7 r33 = r32.u3();
            if (r33 == null) goto L76;
            MessageAdapter r34 = r33.MF();
        L78:
            if ((r34 instanceof q0) == true) goto L81;
            r34 = null;
        L81:
            if (r34 == null) goto L87;
            k0 r35 = r34.Q7();
            if (r35 == null) goto L87;
            com.larus.bmhome.chat.component.trace.z r36 = (com.larus.bmhome.chat.component.trace.z) r35.invoke();
            if (r36 == null) goto L87;
            Set r37 = r36.RY();
        L88:
            if (r37 != null) goto L90;
        L92:
            boolean r38 = false;
        L93:
            if (r38 == false) goto L146;
            r37.add(r31);
            if (r3.i == false) goto L120;
            hy9.d r39 = a.a();
            String r40 = AppHost.a.getApplication().getString(2131906324);
            com.larus.uaigc.chat.markdown.image.component.a r41 = r27.c;
            if (r41 == null) goto L99;
            String r110 = r41.L();
        L100:
            com.larus.uaigc.chat.markdown.image.component.a r42 = r27.c;
            if (r42 == null) goto L109;
            z0 r43 = r42.P();
            if (r43 == null) goto L109;
            com.larus.bmhome.actionbar.model.r r44 = r43.q;
            if (r44 == null) goto L109;
            Integer r45 = r44.a;
            if (r45 == null) goto L109;
            String r111 = r45.toString();
        L110:
            com.larus.uaigc.chat.markdown.image.component.a r46 = r27.c;
            if (r46 == null) goto L117;
            z0 r47 = r46.P();
            if (r47 == null) goto L117;
            com.larus.bmhome.actionbar.model.r r48 = r47.q;
            if (r48 == null) goto L117;
            String r112 = r48.g;
        L118:
            IAIChatControlTraceService.Companion r49 = IAIChatControlTraceService.a;
            hy9.d.a.b(r39, r40, null, null, "picture_overview", "edit_entrance", r110, null, r111, r112, r49.bb(r49.gb()), Boolean.valueOf(com.larus.im.bean.message.a.C0(r3.d)), tz9.a.a(r3.d), null, null, null, null, null, null, 1044550);
        L117:
            r112 = null;
        L109:
            r111 = null;
            goto L110
        L99:
            r110 = null;
        L120:
            if (r3.j == false) goto L146;
            hy9.d r50 = a.a();
            String r51 = AppHost.a.getApplication().getString(2131906331);
            com.larus.uaigc.chat.markdown.image.component.a r52 = r27.c;
            if (r52 == null) goto L124;
            String r113 = r52.L();
        L125:
            com.larus.uaigc.chat.markdown.image.component.k r53 = r27.d;
            if (r53 == null) goto L134;
            z0 r54 = r53.P();
            if (r54 == null) goto L134;
            com.larus.bmhome.actionbar.model.r r55 = r54.q;
            if (r55 == null) goto L134;
            Integer r56 = r55.a;
            if (r56 == null) goto L134;
            String r114 = r56.toString();
        L135:
            com.larus.uaigc.chat.markdown.image.component.k r57 = r27.d;
            if (r57 == null) goto L142;
            z0 r58 = r57.P();
            if (r58 == null) goto L142;
            com.larus.bmhome.actionbar.model.r r59 = r58.q;
            if (r59 == null) goto L142;
            String r115 = r59.g;
        L143:
            IAIChatControlTraceService.Companion r60 = IAIChatControlTraceService.a;
            hy9.d.a.b(r50, r51, null, null, "picture_overview", "single_function", r113, null, r114, r115, r60.bb(r60.gb()), Boolean.valueOf(com.larus.im.bean.message.a.C0(r3.d)), tz9.a.a(r3.d), null, null, null, null, null, null, 1044550);
        L142:
            r115 = null;
        L134:
            r114 = null;
            goto L135
        L124:
            r113 = null;
            goto L125
        L90:
            if (r37.contains(r31) == true) goto L92;
            r38 = true;
        L87:
            r37 = null;
        L76:
            r34 = null;
            goto L78
        L145:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L146:
            boolean r61 = Intrinsics.areEqual(PollingConfigService.a.f("cre_sc_dg"), "1");
            ImageCoverEditView r62 = r22.c;
            if (r3.j == false) goto L157;
            Message r63 = r3.d;
            if (r63 != null) goto L151;
        L153:
            boolean r64 = false;
        L154:
            if (r64 == true) goto L157;
            if (r61 == true) goto L157;
            boolean r65 = true;
        L158:
            Boolean r66 = Boolean.valueOf(r65);
            if (r3.i == false) goto L169;
            Message r67 = r3.d;
            if (r67 != null) goto L163;
        L165:
            boolean r68 = false;
        L166:
            if (r68 == true) goto L169;
            if (r61 == true) goto L169;
            boolean r69 = true;
        L170:
            r62.a(new n0(r66, Boolean.valueOf(r69)), new p(r3, r27));
            r27.p = true;
            return;
        L163:
            if (com.larus.im.bean.message.a.e0(r67) != true) goto L165;
            r68 = true;
        L169:
            r69 = false;
            goto L170
        L151:
            if (com.larus.im.bean.message.a.e0(r63) != true) goto L153;
            r64 = true;
        L157:
            r65 = false;
            goto L158
        L63:
            r25 = false;
            goto L64
        L54:
            if (r3.j == true) goto L57;
            r24 = false;
            goto L58
        L29:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L30:
            ImageView r70 = r4.g;
            ViewGroup.LayoutParams r116 = r70.getLayoutParams();
            if (r116 == null) goto L172;
            ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r116;
            r117.setMarginStart(0);
            r70.setLayoutParams(r117);
            goto L33
        L172:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L21:
            r12 = 8;
            goto L22
        L17:
            r10 = 8;
            goto L18
        L175:
            return;
        L12:
            r3 = null;
            goto L13
        L174:
            return;
        L7:
            r1 = false;
            goto L8
        }

        public MDImageScrollViewHolder(LarusItemMarkdownCreationImageScrollBinding r2, CoroutineScope r3, com.larus.uaigc.chat.markdown.image.component.a r4, com.larus.uaigc.chat.markdown.image.component.k r5, Function0<? extends q0.a> r6, Function1<? super Continuation<? super Message>, ? extends Object> r7, Function2<? super Message, ? super Continuation<? super Map<String, ? extends Object>>, ? extends Object> r8) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            Intrinsics.checkNotNullParameter(r3, "scope");
            Intrinsics.checkNotNullParameter(r6, "modelProviderGetter");
            Intrinsics.checkNotNullParameter(r7, "messageGetter");
            Intrinsics.checkNotNullParameter(r8, "commonParamGetter");
            super(r2.a);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            LazyThreadSafetyMode r9 = LazyThreadSafetyMode.NONE;
            this.h = LazyKt.lazy(r9, new f(this));
            this.i = LazyKt.lazy(r9, new g(this));
            this.j = LazyKt.lazy(r9, new h(this));
            this.k = LazyKt.lazy(r9, new i(this));
            this.l = LazyKt.lazy(r9, new j(this));
            this.q = LazyKt.lazy(r9, new k(this));
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.j.size();
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((MDImageScrollViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        final MDImageScrollViewHolder r11 = new MDImageScrollViewHolder(LarusItemMarkdownCreationImageScrollBinding.a(LayoutInflater.from(r9.getContext()), r9), this.a, this.b, this.c, this.d, this.h, this.i);
        ExposureTrackerExtKt.a(((RecyclerView.ViewHolder) r11).itemView, new b(r11, this));
        return r11;
    }

    public final void y2(final MDImageScrollViewHolder r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "holder");
        final fz9.c r2 = (fz9.c) ListProtector.get(this.j, r19);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r2, "data");
        fz9.c r4 = r18.m;
        ResizeOptions r5 = null;
        if (r4 == null) goto L7;
        Message r6 = r4.getMessage();
        if (r6 == null) goto L7;
        String r7 = r6.getMessageId();
    L8:
        Message r8 = r2.getMessage();
        if (r8 == null) goto L11;
        String r9 = r8.getMessageId();
    L13:
        if (Intrinsics.areEqual(r7, r9) == false) goto L23;
        fz9.c r10 = r18.m;
        if (r10 == null) goto L17;
        String r11 = r10.getTaskId();
    L19:
        if (Intrinsics.areEqual(r11, r2.getTaskId()) == false) goto L23;
        if ((r18.m instanceof fz9.e) == false) goto L23;
        boolean r12 = true;
    L24:
        r18.m = r2;
        r18.n = Integer.valueOf(r19);
        r18.o = false;
        e1.o(r18.a.h);
        e1.o(r18.a.g);
        e1.o(r18.a.d);
        e1.o(r18.a.e);
        e1.o(r18.a.c);
        int r3 = r2.getWidth();
        int r13 = r2.getHeight();
        ConstraintLayout r14 = r18.a.a;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L77;
        RecyclerView.LayoutParams r16 = (RecyclerView.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r16).width = r3;
        ((ViewGroup.MarginLayoutParams) r16).height = r13;
        r14.setLayoutParams(r16);
        r18.p = false;
        if ((r2 instanceof fz9.d) == false) goto L62;
        fz9.d r17 = (fz9.d) r2;
        e1.x(r18.a.j);
        if (r12 == false) goto L31;
        r18.a.j.setAlpha(0.0f);
    L32:
        ImageInfo r20 = r17.f;
        if (r20 == null) goto L37;
        Image r21 = r20.c;
        if (r21 == null) goto L37;
        String r22 = r21.a;
    L38:
        if (r22 != null) goto L40;
    L43:
        boolean r23 = true;
    L45:
        if (r23 == false) goto L47;
        FLogger.a.i("MDImageScrollViewHolder", " bindData error imageUrl is empty");
    L47:
        Uri r110 = com.larus.image.loader.b0.a(r22, "MDImageScrollViewHolder", false, false, 6);
        ImageInfo r24 = r17.f;
        if (r24 == null) goto L50;
        Image r25 = r24.b;
    L51:
        String r26 = dp8.e.b(r25);
        if (r26 == null) goto L54;
        Uri r111 = com.larus.image.loader.b0.a(r26, "MDImageScrollViewHolder_thumb", false, false, 6);
    L55:
        com.larus.uaigc.chat.markdown.image.component.i r112 = (com.larus.uaigc.chat.markdown.image.component.i) r18.i.getValue();
        SimpleDraweeView r113 = r18.a.j;
        MDImageScrollViewHolder.b r114 = (MDImageScrollViewHolder.b) r18.q.getValue();
        int r27 = r17.b;
        int r28 = r17.c;
        if (r27 <= 1) goto L60;
        if (r28 <= 1) goto L60;
        r5 = new ResizeOptions(r27, r28);
    L60:
        r112.d(r113, r111, r110, "MDImageScrollViewHolder", r114, r5);
    L72:
        e1.d(((RecyclerView.ViewHolder) r18).itemView, new com.larus.uaigc.chat.markdown.image.a(this, r2, r18));
        this.f.invoke(r2, ((RecyclerView.ViewHolder) r18).itemView);
        return;
    L54:
        r111 = null;
        goto L55
    L50:
        r25 = null;
        goto L51
    L40:
        if (r22.length() == 0) goto L43;
        r23 = false;
    L37:
        r22 = null;
        goto L38
    L31:
        r18.a.j.setAlpha(1.0f);
        ((com.larus.uaigc.chat.markdown.image.component.c) r18.h.getValue()).a(null, null);
        goto L32
    L62:
        if ((r2 instanceof fz9.e) == false) goto L75;
        fz9.e r29 = (fz9.e) r2;
        e1.o(r18.a.j);
        ((com.larus.uaigc.chat.markdown.image.component.c) r18.h.getValue()).a(r29.a, r29.d);
        if (r29.d == null) goto L72;
        if (r29.a == null) goto L72;
        nq9.f r30 = m3.a.o();
        if (r30 == null) goto L72;
        OldUgcGenImgPerfMonitor r31 = r30.a(true);
        if (r31 == null) goto L72;
        r31.e(r29.d, r29.a);
        goto L72
    L75:
        throw new NoWhenBranchMatchedException();
    L77:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L17:
        r11 = null;
    L23:
        r12 = false;
        goto L24
    L11:
        r9 = null;
    L7:
        r7 = null;
        goto L8
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        MDImageScrollViewHolder r5 = (MDImageScrollViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        Object r6 = CollectionsKt.firstOrNull(r4);
        if ((r6 instanceof o) == false) goto L5;
        o r7 = (o) r6;
    L6:
        if (r7 == null) goto L12;
        int r8 = r7.a;
        int r9 = r7.b;
        ConstraintLayout r10 = r5.a.a;
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if (r0 == null) goto L11;
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) r0;
        ((ViewGroup.MarginLayoutParams) r1).width = r8;
        ((ViewGroup.MarginLayoutParams) r1).height = r9;
        r10.setLayoutParams(r1);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L12:
        y2(r5, r3);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public MDImageScrollAdapter(LifecycleCoroutineScope r2, com.larus.uaigc.chat.markdown.image.component.a r3, com.larus.uaigc.chat.markdown.image.component.k r4, x r5, y r6, z r7, a0 r8, Function1 r9, Function2 r10) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r5, "modelProviderGetter");
        Intrinsics.checkNotNullParameter(r6, "clickListener");
        Intrinsics.checkNotNullParameter(r7, "longClickListenerBinder");
        Intrinsics.checkNotNullParameter(r8, "onExpose");
        Intrinsics.checkNotNullParameter(r9, "messageGetter");
        Intrinsics.checkNotNullParameter(r10, "commonParamGetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = CollectionsKt.emptyList();
    }
}
