package com.larus.share.impl.panel;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.LocalImageWatermarkRequest;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.platform.service.z2;
import com.larus.share.impl.databinding.LarusShareLayoutPanelItemBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 l2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001lBO\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020 0-J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\u0018\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u000202H\u0017J\u000e\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\fJ\u0018\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020$2\u0006\u00108\u001a\u00020\fH\u0007J\u001b\u0010;\u001a\u00020+2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0-H\u0001¢\u0006\u0002\b>J\u001a\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020=2\b\b\u0002\u0010A\u001a\u00020\fH\u0002J\u0018\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020$H\u0007J\u0012\u0010E\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020 H\u0002J\u0012\u0010H\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u00010$H\u0002J$\u0010I\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u00010$2\b\u0010J\u001a\u0004\u0018\u00010$2\u0006\u0010K\u001a\u00020$H\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020 H\u0002J\u001e\u0010N\u001a\u0004\u0018\u00010$*\u00020\n2\u0006\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fH\u0002J \u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u0002022\u0006\u0010G\u001a\u00020 H\u0002J\u0010\u0010T\u001a\u00020+2\u0006\u0010G\u001a\u00020 H\u0002J\u001c\u0010U\u001a\u00020+*\u00020V2\u0006\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020$H\u0002J\u0010\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020[H\u0016J\u0006\u0010\\\u001a\u00020+J\u0018\u0010]\u001a\u00020\f2\u0006\u0010J\u001a\u00020$2\u0006\u0010^\u001a\u00020\nH\u0002J\u0012\u0010_\u001a\u00020\f2\b\u0010`\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010bJ\u001e\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020e2\u0006\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010fJ\"\u0010g\u001a\u0004\u0018\u00010$2\u0006\u0010h\u001a\u00020$2\b\u0010i\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u0010jJ\u001e\u0010k\u001a\u00020\n2\u0006\u0010d\u001a\u00020e2\u0006\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/larus/share/impl/panel/SharePanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/share/impl/panel/SharePanelViewHolder;", "context", "Landroid/content/Context;", "sharePanelDialog", "Landroidx/fragment/app/DialogFragment;", "callback", "Lcom/larus/share/impl/panel/SharePanelCallback;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "isOneGroup", "", "isImmersive", "isSupportWxMiniAppShare", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/DialogFragment;Lcom/larus/share/impl/panel/SharePanelCallback;Lcom/larus/bmhome/share/panel/FlowShareContent;ZLjava/lang/Boolean;Z)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getCallback", "()Lcom/larus/share/impl/panel/SharePanelCallback;", "setCallback", "(Lcom/larus/share/impl/panel/SharePanelCallback;)V", "getShareContent", "()Lcom/larus/bmhome/share/panel/FlowShareContent;", "setShareContent", "(Lcom/larus/bmhome/share/panel/FlowShareContent;)V", "Ljava/lang/Boolean;", "dataList", "", "Lcom/larus/platform/model/share/ShareItemConfig;", "panelClickable", "disabledTipMap", "", "", "startLoadingTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "destroyed", "setData", "", "itemList", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "setPanelViewClickable", "clickable", "setElementClickable", "channel", "setElementEnableStates", "items", "Lcom/larus/bmhome/share/panel/SharePanelItemEnableState;", "setElementEnableStates$impl_mainlandRelease", "setElementEnableState", "itemState", "notify", "replaceItemByChannel", "oldChannel", "newChannel", "showDisableTip", "shouldBlockFileEgress", "itemData", "showFileSecurityBlockTip", "reportFileEgressBlocked", "shareType", "entry", "getShareType", "shareItemConfig", "getDownloadFilePath", "saveImage", "saveVideo", "mobAICreationLoadingStatus", "status", "duration", "mobPictureDownload", "putMixedRichMediaTraceParam", "Lorg/json/JSONObject;", "key", "value", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "destroy", "shareWatermarkApplicable", "content", "isRemoteUrl", "url", "resolveWatermarkedShareContent", "(Lcom/larus/bmhome/share/panel/FlowShareContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyLocalWatermark", "service", "Lcom/larus/platform/service/DownloadWatermarkService;", "(Lcom/larus/platform/service/DownloadWatermarkService;Lcom/larus/bmhome/share/panel/FlowShareContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "relocateNextTo", "watermarkedPath", "originalLocalPath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyRemoteUrlWatermark", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SharePanelAdapter extends RecyclerView.Adapter<SharePanelViewHolder> {
    public static final Set<String> n = null;
    public static final Set<String> o = null;
    public Context a;
    public DialogFragment b;
    public g c;
    public com.larus.bmhome.share.panel.b d;
    public final boolean e;
    public final Boolean f;
    public final boolean g;
    public List<jr9.a> h;
    public boolean i;
    public final Map<String, String> j;
    public long k;
    public final CoroutineScope l;
    public boolean m;

    public static final class a {
    }

    static {
        n = SetsKt.setOf(new String[]{"image", "video", "file"});
        o = SetsKt.setOf(new String[]{"forward", "merge_forward", "single_forward", "ask_doubao", "collect", "report", "delete", "permission_setting", "copy_link", "copy_text", "copy_feishu_link", "publish", "set_private"});
    }

    public final void A2() {
        if (this.m == false) goto L5;
        return;
    L5:
        this.m = true;
        CoroutineScopeKt.cancel$default(this.l, null, 1, null);
        this.h.clear();
        ((LinkedHashMap) this.j).clear();
        this.a = null;
        this.c = null;
        this.d = null;
        this.b = null;
        this.k = -1;
    }

    public final int getItemCount() {
        if (this.m == false) goto L7;
        return 0;
    L7:
        return this.h.size();
    }

    public final Context getContext() {
        return this.a;
    }

    public final String B2(jr9.a r3) {
        if (Intrinsics.areEqual(r3.b(), "wechat") == false) goto L10;
        if (Intrinsics.areEqual(r3.c(), "mini_app") == false) goto L10;
        if (this.g == true) goto L10;
        return "url";
    L10:
        return r3.c();
    }

    public final boolean F2(jr9.a r5) {
        String r0 = B2(r5);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r0, "file_url") == false) goto L19;
        com.larus.share.impl.util.e.a.getClass();
        if (CollectionsKt.contains(com.larus.share.impl.util.e.b, r5.b()) == true) goto L29;
        FlowFileProtectionService r6 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r6 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L30;
        return true;
    L30:
        return false;
    L12:
        if (r6.I0() != true) goto L14;
        r7 = true;
        goto L15
    L29:
        return false;
    L19:
        if (n.contains(r0) == true) goto L21;
        return false;
    L21:
        if (CollectionsKt.contains(o, r5.b()) == true) goto L34;
        FlowFileProtectionService r8 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r8 != null) goto L26;
        return false;
    L26:
        if (r8.I0() != true) goto L33;
        return true;
    L33:
        return false;
    L34:
        return false;
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
        A2();
    }

    public final void setData(List<jr9.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemList");
        if (this.m == false) goto L5;
        return;
    L5:
        this.h = CollectionsKt.toMutableList(r2);
    }

    public final boolean D2(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "oldChannel");
        Intrinsics.checkNotNullParameter(r7, "newChannel");
        Iterator<jr9.a> r0 = this.h.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().b(), r6) == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 >= 0) goto L12;
        return false;
    L12:
        ListProtector.set(this.h, r2, new jr9.a(r7, null, 14));
        notifyDataSetChanged();
        FLogger.a.i("SharePanelAdapter", "replaceItemByChannel: " + r6 + " -> " + r7 + " at index=" + r2);
        return true;
    L9:
        r2 = -1;
        goto L10
    }

    public final boolean E2(com.larus.bmhome.share.panel.j r7, boolean r8) {
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((jr9.a) r1).b(), r7.a) == false) goto L4;
    L9:
        jr9.a r2 = (jr9.a) r1;
        if (r2 == null) goto L21;
        jr9.b r3 = r2.a;
        if (r3 == null) goto L21;
        this.j.put(r7.a, r7.c);
        boolean r4 = r3.f;
        boolean r9 = r7.b;
        if (r4 != r9) goto L17;
        return true;
    L17:
        r2.a = jr9.b.a(r3, r9, false, 223);
        if (r8 == false) goto L20;
        notifyDataSetChanged();
    L20:
        return true;
    L21:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        final SharePanelViewHolder r9 = (SharePanelViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final jr9.a r10 = (jr9.a) ListProtector.get(this.h, r8);
        boolean r1 = false;
        if (r10.a != null) goto L9;
        SharePanelServiceDelegate r0 = SharePanelServiceDelegate.b;
        String r2 = r10.b();
        Boolean r3 = this.f;
        if (r3 == null) goto L7;
        boolean r4 = r3.booleanValue();
    L8:
        r10.a = r0.e(r2, r4);
        goto L9
    L7:
        r4 = false;
    L9:
        jr9.b r5 = r10.a;
        if (r5 != null) goto L12;
    L72:
        final LinearLayout r6 = r9.a.a;
        r6.setOnTouchListener(new com.larus.share.impl.panel.a(r10, this));
        e1.d(r6, new b(this, r10, r6, r9));
        jr9.b r11 = r10.a;
        if (r11 != null) goto L75;
    L77:
        boolean r12 = false;
    L78:
        if (r12 == true) goto L80;
    L82:
        View r13 = ((RecyclerView.ViewHolder) r9).itemView;
        if (r1 == false) goto L85;
        float r14 = 1.0f;
    L86:
        r13.setAlpha(r14);
        g r15 = this.c;
        if (r15 == null) goto L90;
        r15.c(r10.b());
        return;
    L90:
        return;
    L85:
        r14 = 0.3f;
        goto L86
    L80:
        if (F2(r10) == true) goto L82;
        r1 = true;
        goto L82
    L75:
        if (r11.f != true) goto L77;
        r12 = true;
        goto L78
    L12:
        if (this.e == false) goto L22;
        int r16 = r5.b;
        if (r16 == 0) goto L16;
        r9.a.c.setImageResource(r16);
    L18:
        if (Intrinsics.areEqual(this.f, Boolean.TRUE) == false) goto L23;
        Context r17 = this.a;
        if (r17 == null) goto L23;
        r9.a.e.setTextColor(ContextCompat.getColor(r17, 2131103298));
    L23:
        Integer r18 = r5.e.get(r10.c());
        if ((!r5.e.isEmpty()) == false) goto L27;
        if (r18 == null) goto L27;
        r9.a.e.setText(r18.intValue());
    L31:
        String r19 = B2(r10);
        if (Intrinsics.areEqual(r19, "image") == true) goto L34;
    L51:
        boolean r20 = false;
    L53:
        if (Intrinsics.areEqual(r19, "video") == true) goto L55;
    L57:
        boolean r21 = false;
    L59:
        if (z2.a.getCreationShareSettings().b() == false) goto L61;
        if (r20 == false) goto L61;
    L62:
        jr9.b r22 = r10.a;
        if (r22 != null) goto L65;
    L67:
        boolean r23 = false;
    L69:
        if (r23 == false) goto L71;
        r9.a.b.setVisibility(0);
        r9.a.d.setVisibility(0);
        r9.a.c.setVisibility(8);
        goto L72
    L71:
        r9.a.b.setVisibility(8);
        r9.a.d.setVisibility(8);
        r9.a.c.setVisibility(0);
        goto L72
    L65:
        if (r22.h != true) goto L67;
        r23 = true;
    L61:
        if (r21 == false) goto L72;
    L55:
        if (Intrinsics.areEqual(r10.b(), "save_video") == false) goto L57;
        r21 = true;
        goto L59
    L34:
        if (Intrinsics.areEqual(r10.b(), "save_image") == false) goto L51;
        com.larus.bmhome.share.panel.b r24 = this.d;
        if (r24 != null) goto L38;
    L40:
        boolean r25 = false;
    L41:
        if (r25 == true) goto L50;
        if (r24 == null) goto L48;
        Job r26 = r24.t;
        if (r26 == null) goto L48;
        if (r26.isActive() != true) goto L48;
        boolean r27 = true;
    L49:
        if (r27 == false) goto L51;
    L48:
        r27 = false;
    L50:
        r20 = true;
        goto L53
    L38:
        if (r24.r != true) goto L40;
        r25 = true;
    L27:
        int r28 = r5.c;
        if (r28 <= 0) goto L30;
        r9.a.e.setText(r28);
        goto L31
    L30:
        r9.a.e.setText(r5.d);
        goto L31
    L16:
        r9.a.c.setImageResource(r5.a);
        goto L18
    L22:
        r9.a.c.setImageResource(r5.a);
        goto L23
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        View r10 = LayoutInflater.from(this.a).inflate(2131563124, null, false);
        int r11 = 2131372676;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131372676);
        if (r3 == null) goto L13;
        r11 = 2131375127;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r10, 2131375127);
        if (r4 == null) goto L13;
        r11 = 2131382049;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r10, 2131382049);
        if (r5 == null) goto L13;
        r11 = 2131390156;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, 2131390156);
        if (r6 == null) goto L13;
        return new SharePanelViewHolder(new LarusShareLayoutPanelItemBinding((LinearLayout) r10, r3, r4, r5, r6));
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static void C2(String r15, int r16, jr9.a r17) {
        JSONObject r6 = new JSONObject();
    L32:
        e = move-exception;
        FLogger.a.e("SharePanelAdapter", "error in SharePanelAdapter mobAICreationLoadingStatus " + e.getLocalizedMessage());
    L34:
        TrackParams r0 = new TrackParams().merge(r6);
        by7.a r1 = new by7.a("ai_creation_loading_status");
        r1.a.merge(r0);
        r1.b();
        return;
    L4:
        if (Intrinsics.areEqual(r17.b(), "save_image") == false) goto L6;
        String r7 = "picture_detail";
    L7:
        String r8 = r17.b.get("ai_creation_task_id");     // Catch: JSONException -> L32
        String r9 = "";
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        String r10 = r17.b.get("template_id");     // Catch: JSONException -> L32
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        String r11 = r17.b.get("has_original_image");     // Catch: JSONException -> L32
        int r13 = 0;
        if (r11 == null) goto L20;
        Intrinsics.checkNotNullParameter(r11, "<this>");     // Catch: JSONException -> L32
        int r12 = CastIntegerProtector.parseInt(r11);     // Catch: NumberFormatException -> L37 JSONException -> L32
    L21:
        String r14 = r17.b.get("message_id");     // Catch: JSONException -> L32
        if (r14 == null) goto L25;
        r9 = r14;
    L25:
        String r2 = r17.b.get("is_replica_gen");     // Catch: JSONException -> L32
        if (r2 == null) goto L30;
        Intrinsics.checkNotNullParameter(r2, "<this>");     // Catch: JSONException -> L32
        r13 = CastIntegerProtector.parseInt(r2);     // Catch: NumberFormatException -> L36 JSONException -> L32
    L30:
        r6.put("status", r15);     // Catch: JSONException -> L32
        r6.put("duration", r16);     // Catch: JSONException -> L32
        r6.put("message_id", r9);     // Catch: JSONException -> L32
        r6.put("loading_begin_page", r7);     // Catch: JSONException -> L32
        r6.put("ai_creation_task_id", r8);     // Catch: JSONException -> L32
        r6.put("template_id", r10);     // Catch: JSONException -> L32
        r6.put("has_original_image", r12);     // Catch: JSONException -> L32
        r6.put("is_replica_gen", r13);     // Catch: JSONException -> L32
    L20:
        r12 = 0;
        goto L21
    L6:
        r7 = "video_detail";
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v13, types: [com.larus.platform.service.watermark.WatermarkPerfLogger$a] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    public final Object y2(DownloadWatermarkService r19, com.larus.bmhome.share.panel.b r20, Continuation<? super com.larus.bmhome.share.panel.b> r21) {
        com.larus.bmhome.share.panel.b r1 = r20;
        if ((r21 instanceof SharePanelAdapter$applyLocalWatermark$1) == false) goto L7;
        SharePanelAdapter$applyLocalWatermark$1 r2 = (SharePanelAdapter$applyLocalWatermark$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r5 = r2.label;
        String r8 = null;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L17;
        if (r5 != 2) goto L16;
        com.larus.platform.service.watermark.c r6 = (com.larus.platform.service.watermark.c) r2.L$3;
        com.larus.platform.service.watermark.g r7 = (com.larus.platform.service.watermark.g) r2.L$2;
        WatermarkPerfLogger.a r9 = (WatermarkPerfLogger.a) r2.L$1;
        com.larus.bmhome.share.panel.b r10 = (com.larus.bmhome.share.panel.b) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L63
        com.larus.bmhome.share.panel.b r11 = r10;
        WatermarkPerfLogger.a r12 = r9;
    L74:
        String r13 = (String) r0;     // Catch: Throwable -> L63
        if (r13 != null) goto L77;
        r13 = ((com.larus.platform.service.watermark.c.b) r6).a;     // Catch: Throwable -> L63
    L77:
        r11 = com.larus.bmhome.share.panel.b.a(r11, r13, null, null, null, null, null, false, 67108860);     // Catch: Throwable -> L63
        com.larus.platform.service.watermark.g r14 = r7;
        r5 = r12;
    L81:
        boolean r15 = r14 instanceof com.larus.platform.service.watermark.g.d;     // Catch: Throwable -> L63
        if (r15 == false) goto L84;
        WatermarkPerfLogger.Result r16 = WatermarkPerfLogger.Result.SUCCESS;     // Catch: Throwable -> L63
    L85:
        if (r15 == true) goto L87;
        r8 = "fallback_to_origin";
    L87:
        r5.b(r16, r8);     // Catch: Throwable -> L63
        return r11;
    L84:
        r16 = WatermarkPerfLogger.Result.FAIL;     // Catch: Throwable -> L63
        goto L85
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        WatermarkPerfLogger.a r17 = (WatermarkPerfLogger.a) r2.L$1;
        com.larus.bmhome.share.panel.b r18 = (com.larus.bmhome.share.panel.b) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L20
        WatermarkPerfLogger.a r22 = r17;
        r1 = r18;
    L37:
        Object r23 = Result.constructor-impl((com.larus.platform.service.watermark.g) r0);     // Catch: Throwable -> L39
        WatermarkPerfLogger.a r24 = r22;
        r11 = r1;
    L44:
        if (Result.isFailure-impl(r23) == false) goto L46;
        r23 = null;
    L46:
        r14 = (com.larus.platform.service.watermark.g) r23;     // Catch: Throwable -> L63
        r24.a("applyWatermarkToLocalImage");     // Catch: Throwable -> L63
        if ((r14 instanceof com.larus.platform.service.watermark.g.d) == false) goto L49;
        com.larus.platform.service.watermark.g.d r25 = (com.larus.platform.service.watermark.g.d) r14;     // Catch: Throwable -> L63
    L50:
        if (r25 == null) goto L52;
        r6 = r25.a;     // Catch: Throwable -> L63
    L54:
        if ((r6 instanceof com.larus.platform.service.watermark.c.b) == false) goto L78;
        String r110 = r11.a;     // Catch: Throwable -> L63
        if (r110 != null) goto L58;
    L69:
        r110 = null;
    L70:
        String r26 = ((com.larus.platform.service.watermark.c.b) r6).a;     // Catch: Throwable -> L63
        r2.L$0 = r11;     // Catch: Throwable -> L63
        r2.L$1 = r24;     // Catch: Throwable -> L63
        r2.L$2 = r14;     // Catch: Throwable -> L63
        r2.L$3 = r6;     // Catch: Throwable -> L63
        r2.label = 2;     // Catch: Throwable -> L63
        Object r27 = BuildersKt.withContext(Dispatchers.getIO(), new SharePanelAdapter$relocateNextTo$2(r110, r26, null), r2);     // Catch: Throwable -> L63
        if (r27 != r4) goto L73;
        return r4;
    L73:
        r7 = r14;
        r0 = r27;
        r12 = r24;
        goto L74
    L58:
        if (StringsKt.startsWith(r110, "http://", true) == false) goto L60;
    L65:
        boolean r111 = true;
    L67:
        if ((true ^ r111) == false) goto L69;
    L60:
        if (StringsKt.startsWith(r110, "https://", true) == true) goto L65;
        r111 = false;
        goto L67
    L78:
        r5 = r24;
        if ((r6 instanceof com.larus.platform.service.watermark.c.a) == false) goto L81;
        r11 = com.larus.bmhome.share.panel.b.a(r11, null, ((com.larus.platform.service.watermark.c.a) r6).a, null, null, null, null, false, 67108860);     // Catch: Throwable -> L63
        r5 = r24;
        goto L81
    L52:
        r6 = null;
        goto L54
    L49:
        r25 = null;
    L39:
        Throwable th = th;
        r18 = r1;
        r17 = r22;
    L99:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L89
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L89
        r11 = r18;
        r24 = r17;
    L89:
        th = th;
        WatermarkPerfLogger.a r29 = r17;
    L93:
        r29.b(WatermarkPerfLogger.Result.FAIL, th.getClass().getSimpleName());
        throw th;
    L20:
        th = th;
        goto L99
    L22:
        ResultKt.throwOnFailure(r0);
        int r30 = WatermarkPerfLogger.a;
        WatermarkPerfLogger.Version r31 = WatermarkPerfLogger.Version.ENTERPRISE;
        DownloadWatermarkScene r32 = DownloadWatermarkScene.USER_SHARE_IMAGE;
        r22 = WatermarkPerfLogger.a("share_panel_save", r31, r32);
        r22.c(WatermarkPerfLogger.Path.B_LOCAL);
        Bitmap r33 = r1.b;     // Catch: Throwable -> L91
        if (r33 == null) goto L26;
        Intrinsics.checkNotNull(r33);     // Catch: Throwable -> L91
        com.larus.platform.service.watermark.b r112 = new com.larus.platform.service.watermark.b.a(r33);     // Catch: Throwable -> L91
    L30:
        if (r112 != null) goto L33;
        r22.b(WatermarkPerfLogger.Result.FAIL, "no_input");     // Catch: Throwable -> L91
        return r1;
    L33:
        LocalImageWatermarkRequest r34 = new LocalImageWatermarkRequest(r112, LocalImageWatermarkRequest.OutputPreference.SAME_AS_INPUT, r32);     // Catch: Throwable -> L91
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L39
        r2.L$0 = r1;     // Catch: Throwable -> L39
        r2.L$1 = r22;     // Catch: Throwable -> L39
        r2.label = 1;     // Catch: Throwable -> L39
        r0 = r19.b(r34, r2);     // Catch: Throwable -> L39
        if (r0 != r4) goto L37;
        return r4;
    L26:
        String r36 = r1.a;     // Catch: Throwable -> L91
        if (r36 == null) goto L29;
        Intrinsics.checkNotNull(r36);     // Catch: Throwable -> L91
        r112 = new com.larus.platform.service.watermark.b.C0012b(r36);     // Catch: Throwable -> L91
        goto L30
    L29:
        r112 = null;
    L91:
        th = th;
        r29 = r22;
    L63:
        th = th;
        r29 = r5;
    L7:
        r2 = new SharePanelAdapter$applyLocalWatermark$1(this, r21);
        goto L8
    }

    public final Object z2(DownloadWatermarkService r12, com.larus.bmhome.share.panel.b r13, Continuation<? super com.larus.bmhome.share.panel.b> r14) {
        if ((r14 instanceof SharePanelAdapter$applyRemoteUrlWatermark$1) == false) goto L7;
        SharePanelAdapter$applyRemoteUrlWatermark$1 r1 = (SharePanelAdapter$applyRemoteUrlWatermark$1) r14;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        WatermarkPerfLogger.a r16 = (WatermarkPerfLogger.a) r1.L$1;
        r13 = (com.larus.bmhome.share.panel.b) r1.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L34:
        Object r17 = Result.constructor-impl((com.larus.platform.service.watermark.g) r15);     // Catch: Throwable -> L14
    L35:
        com.larus.bmhome.share.panel.b r5 = r13;
    L54:
        Throwable th = th;
    L60:
        r16.b(WatermarkPerfLogger.Result.FAIL, th.getClass().getSimpleName());
        throw th;
    L41:
        if (Result.isFailure-impl(r17) == false) goto L43;
        r17 = null;
    L43:
        com.larus.platform.service.watermark.g r18 = (com.larus.platform.service.watermark.g) r17;     // Catch: Throwable -> L54
        r16.a("exchangeWatermarkUrl");     // Catch: Throwable -> L54
        if ((r18 instanceof com.larus.platform.service.watermark.g.b) == false) goto L47;
        r16.b(WatermarkPerfLogger.Result.SUCCESS, null);     // Catch: Throwable -> L54
        return com.larus.bmhome.share.panel.b.a(r5, ((com.larus.platform.service.watermark.g.b) r18).a, null, null, null, null, null, false, 67108860);
    L47:
        if ((r18 instanceof com.larus.platform.service.watermark.g.a) == false) goto L52;
        FLogger.a.w("SharePanelAdapter", "remoteUrlWatermark degraded: " + ((com.larus.platform.service.watermark.g.a) r18).a);     // Catch: Throwable -> L54
        WatermarkPerfLogger.Result r19 = WatermarkPerfLogger.Result.FAIL;     // Catch: Throwable -> L54
        String r110 = ((com.larus.platform.service.watermark.g.a) r18).a;     // Catch: Throwable -> L54
        if (r110 != null) goto L51;
        r110 = "degraded";
    L51:
        r16.b(r19, r110);     // Catch: Throwable -> L54
        return r5;
    L52:
        r16.b(WatermarkPerfLogger.Result.FAIL, "exchange_null");     // Catch: Throwable -> L54
        return r5;
    L14:
        Throwable th2 = th;
    L65:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L56
        r17 = Result.constructor-impl(ResultKt.createFailure(th2));     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        WatermarkPerfLogger.a r111 = r16;
        th = th;
    L59:
        th = th;
        r16 = r111;
        goto L60
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        int r112 = WatermarkPerfLogger.a;
        WatermarkPerfLogger.Version r113 = WatermarkPerfLogger.Version.ENTERPRISE;
        DownloadWatermarkScene r7 = DownloadWatermarkScene.CI_GEN_IMAGE_SHARE;
        r111 = WatermarkPerfLogger.a("share_panel_save", r113, r7);
        r111.c(WatermarkPerfLogger.Path.A);
        String r8 = r13.a;     // Catch: Throwable -> L58
        if (r8 != null) goto L22;
    L25:
        boolean r9 = true;
    L26:
        if (r9 == false) goto L29;
        r111.b(WatermarkPerfLogger.Result.FAIL, "no_image_url");     // Catch: Throwable -> L58
        return r13;
    L29:
        com.larus.platform.service.watermark.d r10 = new com.larus.platform.service.watermark.d(r8, r7);     // Catch: Throwable -> L58
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L36
        r1.L$0 = r13;     // Catch: Throwable -> L36
        r1.L$1 = r111;     // Catch: Throwable -> L36
        r1.label = 1;     // Catch: Throwable -> L36
        Object r114 = r12.c(r10, r1);     // Catch: Throwable -> L36
        if (r114 != r3) goto L33;
        return r3;
    L33:
        r15 = r114;
        r16 = r111;
    L36:
        th = move-exception;
        th2 = th;
        r16 = r111;
        goto L65
    L22:
        if (r8.length() == 0) goto L25;
        r9 = false;
    L58:
        th = th;
    L7:
        r1 = new SharePanelAdapter$applyRemoteUrlWatermark$1(this, r14);
        goto L8
    }

    public SharePanelAdapter(Context r1, DialogFragment r2, g r3, com.larus.bmhome.share.panel.b r4, boolean r5, Boolean r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = new ArrayList();
        this.i = true;
        this.j = new LinkedHashMap();
        this.k = -1;
        this.l = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public /* synthetic */ SharePanelAdapter(FragmentActivity r11, DialogFragment r12, g r13, com.larus.bmhome.share.panel.b r14, Boolean r15, boolean r16, int r17) {
        if ((r17 & 16) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r17 & 32) == 0) goto L9;
        Boolean r8 = Boolean.FALSE;
    L11:
        if ((r17 & 64) == 0) goto L13;
        boolean r9 = false;
    L14:
        this(r11, r12, r13, r14, r7, r8, r9);
        return;
    L13:
        r9 = r16;
        goto L14
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = true;
        goto L7
    }
}
