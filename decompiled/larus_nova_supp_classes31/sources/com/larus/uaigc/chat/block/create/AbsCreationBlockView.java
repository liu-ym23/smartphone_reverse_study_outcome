package com.larus.uaigc.chat.block.create;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.creation.CreationExposureMediaType;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kc8.a0;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;
import tx9.a4;
import tx9.u2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 r2\u00020\u00012\u00020\u0002:\u0001rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010`\u001a\u00020>H&J\u0089\u0001\u0010a\u001a\u00020?2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010-\u001a\u00020\n2\b\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010d\u001a\u00020e2\u0006\u0010)\u001a\u00020\n2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n2\u001c\b\u0002\u0010;\u001a\u0016\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?\u0018\u00010<2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020?H\u0017J\b\u0010h\u001a\u00020?H&J\b\u0010i\u001a\u00020?H\u0002J\b\u0010j\u001a\u00020?H\u0002J\u0018\u0010k\u001a\u00020?2\u0006\u0010l\u001a\u00020=2\u0006\u0010m\u001a\u00020nH\u0004J \u0010o\u001a\u00020\n2\u0006\u0010l\u001a\u00020=2\u0006\u0010p\u001a\u00020q2\u0006\u0010m\u001a\u00020nH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R.\u0010;\u001a\u0016\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?\u0018\u00010<X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020L8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bO\u0010*R\u001d\u0010P\u001a\u0004\u0018\u00010Q8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bR\u0010SR\u001d\u0010V\u001a\u0004\u0018\u00010W8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010U\u001a\u0004\bX\u0010YR\u001b\u0010[\u001a\u00020\\8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b_\u0010U\u001a\u0004\b]\u0010^¨\u0006s"}, d2 = {"Lcom/larus/uaigc/chat/block/create/AbsCreationBlockView;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/larus/bmhome/chat/cell/text/components/IScreenshotMobPramsProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "isInit", "", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "message", "Lcom/larus/im/bean/message/Message;", "getMessage", "()Lcom/larus/im/bean/message/Message;", "setMessage", "(Lcom/larus/im/bean/message/Message;)V", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "getCreateBlockConfig", "()Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "setCreateBlockConfig", "(Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;)V", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "setChatParam", "(Lcom/larus/bmhome/chat/ChatParam;)V", "isLastBlockModel", "()Z", "setLastBlockModel", "(Z)V", "isLongPicShare", "setLongPicShare", "blockModel", "Lcom/larus/uaigc/chat/block/create/ICreationBizModel;", "getBlockModel", "()Lcom/larus/uaigc/chat/block/create/ICreationBizModel;", "setBlockModel", "(Lcom/larus/uaigc/chat/block/create/ICreationBizModel;)V", "disableCreateImagePreview", "getDisableCreateImagePreview", "()Ljava/lang/Boolean;", "setDisableCreateImagePreview", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "onItemLongClick", "Lkotlin/Function2;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "Landroid/view/View;", "", "getOnItemLongClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClick", "(Lkotlin/jvm/functions/Function2;)V", "curCreationList", "", "Lcom/larus/im/bean/message/CreationItem;", "getCurCreationList", "()Ljava/util/List;", "setCurCreationList", "(Ljava/util/List;)V", "botId", "", "getBotId", "()Ljava/lang/String;", "isCollectMode", "imageEditorDependency", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "getImageEditorDependency", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "imageEditorDependency$delegate", "Lkotlin/Lazy;", "videoEditorDependency", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "getVideoEditorDependency", "()Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "videoEditorDependency$delegate", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler$delegate", "asView", "bindData", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "maxContentWidth", "", "(Landroidx/fragment/app/Fragment;ZLcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/chat/block/create/ICreationBizModel;Lcom/larus/bmhome/chat/ChatParam;IZLjava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;)V", "onRecycle", "reloadFailedImages", "ensureLifecycle", "bindObservers", "onItemExpose", "itemData", "percentage", "", "tryMarkItemExposed", "mediaType", "Lcom/larus/bmhome/chat/component/creation/CreationExposureMediaType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class AbsCreationBlockView implements LifecycleOwner, bd8.d {
    public static final /* synthetic */ int q = 0;
    public final Context a;
    public boolean b;
    public LifecycleRegistry c;
    public Fragment d;
    public Message e;
    public kc8.q f;
    public ChatParam g;
    public boolean h;
    public boolean i;
    public i j;
    public Boolean k;
    public Function2<? super cz9.b, ? super View, Unit> l;
    public List<CreationItem> m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;

    public static final class a {
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            FLogger.a.e("AbsCreationBlockView", "err! msg=" + r4);
        }
    }

    static {
    }

    public abstract View a();

    public abstract void k();

    public final String c() {
        kc8.q r0 = this.f;
        if (r0 == null) goto L7;
        a0 r1 = r0.d;
        if (r1 == null) goto L7;
        String r2 = r1.getBotId();
    L8:
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    public final CoroutineExceptionHandler e() {
        return (CoroutineExceptionHandler) this.p.getValue();
    }

    public final com.larus.uaigc.chat.markdown.image.component.a f() {
        return (com.larus.uaigc.chat.markdown.image.component.a) this.n.getValue();
    }

    public final com.larus.uaigc.chat.markdown.image.component.k g() {
        return (com.larus.uaigc.chat.markdown.image.component.k) this.o.getValue();
    }

    public final Lifecycle getLifecycle() {
        LifecycleRegistry r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        return null;
    L6:
        return r0;
    }

    public final boolean h() {
        kc8.q r0 = this.f;
        if (r0 == null) goto L7;
        Function0 r1 = r0.e;
        if (r1 == null) goto L7;
        return ((Boolean) r1.invoke()).booleanValue();
    L7:
        return false;
    }

    public void j() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        LifecycleRegistry r1 = this.c;     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");     // Catch: Throwable -> L7
        r1 = null;
    L5:
        r1.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);     // Catch: Throwable -> L7
        this.b = true;     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final Context getContext() {
        return this.a;
    }

    public AbsCreationBlockView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = true;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.n = LazyKt.lazy(r3, new com.larus.uaigc.chat.block.create.a(this));
        this.o = LazyKt.lazy(r3, new com.larus.uaigc.chat.block.create.b(this));
        this.p = LazyKt.lazy(r3, new c());
    }

    public final void i(cz9.b r27, float r28) {
        Intrinsics.checkNotNullParameter(r27, "itemData");
        boolean r5 = false;
        String r6 = null;
        if ((r27 instanceof cz9.h) == false) goto L75;
        if (l(r27, CreationExposureMediaType.IMAGE, r28) == true) goto L7;
        return;
    L7:
        IAIChatControlTraceService.Companion r3 = IAIChatControlTraceService.a;
        cz9.h r7 = (cz9.h) r27;
        Message r8 = r7.e;
        if (r8 == null) goto L10;
        String r9 = r8.getReplyId();
    L12:
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        String r4 = r3.Sa(r9);
        if (r4.length() != 0) goto L17;
        boolean r10 = true;
    L18:
        if (r10 == false) goto L20;
        r4 = "other";
    L20:
        String r11 = r4;
        Integer r12 = Integer.valueOf(r7.f + 1);
        String r13 = c();
        Message r14 = r7.e;
        if (r14 == null) goto L23;
        String r15 = r14.getMessageId();
    L24:
        CreationItem r16 = r7.d;
        if (r16 == null) goto L29;
        ImageData r17 = r16.image;
        if (r17 == null) goto L29;
        String r18 = r17.requestId;
    L30:
        if (r16 == null) goto L34;
        ImageData r19 = r16.image;
        if (r19 == null) goto L34;
        String r110 = r19.key;
    L35:
        if (r16 == null) goto L44;
        CreationGenDetail r20 = r16.genDetail;
        if (r20 == null) goto L44;
        Integer r21 = r20.taskType;
        if (r21 == null) goto L44;
        if (r21.intValue() != 5) goto L44;
        boolean r22 = true;
    L45:
        Boolean r111 = Boolean.valueOf(r22);
        CreationItem r23 = r7.d;
        if (r23 == null) goto L55;
        CreationGenDetail r24 = r23.genDetail;
        if (r24 == null) goto L55;
        Integer r25 = r24.taskType;
        if (r25 == null) goto L55;
        if (r25.intValue() != 7) goto L55;
        boolean r26 = true;
    L56:
        Boolean r112 = Boolean.valueOf(r26);
        Message r29 = r7.e;
        if (r29 == null) goto L59;
        Boolean r113 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r29));
    L60:
        Message r30 = r7.e;
        if (r30 == null) goto L65;
        Map r31 = r30.getExt();
        if (r31 == null) goto L65;
        String r32 = (String) r31.get("ai_create_show_mode");
    L66:
        if (r32 != null) goto L68;
        String r210 = "";
    L69:
        Boolean r211 = Boolean.TRUE;
        Float r212 = Float.valueOf(r28);
        CreationItem r33 = r7.d;
        if (r33 == null) goto L72;
        String r213 = r33.id;
    L73:
        u2.d(r11, r12, null, r13, r15, r18, r110, r111, r112, r113, r210, r211, r212, r213, null, 49152);
        goto L75
    L72:
        r213 = null;
        goto L73
    L68:
        r210 = r32;
    L65:
        r32 = null;
        goto L66
    L59:
        r113 = null;
    L55:
        r26 = false;
    L44:
        r22 = false;
    L34:
        r110 = null;
    L29:
        r18 = null;
        goto L30
    L23:
        r15 = null;
        goto L24
    L17:
        r10 = false;
        goto L18
    L10:
        r9 = null;
    L75:
        if ((r27 instanceof cz9.o) == false) goto L109;
        cz9.o r34 = (cz9.o) r27;
        CreationItem r35 = r34.d;
        if (r35 == null) goto L86;
        VideoData r36 = r35.video;
        if (r36 == null) goto L86;
        Integer r37 = r36.status;
        if (r37 == null) goto L86;
        if (r37.intValue() != 3) goto L86;
        r5 = true;
    L86:
        if (r5 == true) goto L88;
        return;
    L88:
        if (l(r27, CreationExposureMediaType.VIDEO, r28) == true) goto L90;
        return;
    L90:
        CreationItem r1 = r34.d;
        if (r1 == null) goto L95;
        VideoData r2 = r1.video;
        if (r2 == null) goto L95;
        String r38 = r2.vid;
    L96:
        Message r39 = r34.e;
        if (r39 == null) goto L99;
        String r40 = r39.getMessageId();
    L100:
        String r41 = c();
        Message r42 = r34.e;
        if (r42 == null) goto L103;
        String r114 = tz9.a.a(r42);
    L104:
        Integer r115 = Integer.valueOf(r34.f + 1);
        CreationItem r43 = r34.d;
        if (r43 == null) goto L107;
        r6 = r43.id;
    L107:
        a4.d(r38, r40, r41, r114, r115, r6, Float.valueOf(r28), null, 384);
        return;
    L103:
        r114 = null;
        goto L104
    L99:
        r40 = null;
    L95:
        r38 = null;
        goto L96
    }

    public final boolean l(cz9.b r4, CreationExposureMediaType r5, float r6) {
        Fragment r0 = this.d;
        if (r0 == null) goto L17;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L19;
        qd8.c r2 = r1.getAbility(qd8.c.class);
        if (r2 == null) goto L20;
        Message r3 = r4.getMessage();
        String r7 = null;
        if (r3 == null) goto L11;
        String r8 = r3.getMessageId();
    L12:
        CreationItem r9 = r4.a();
        if (r9 == null) goto L16;
        r7 = r9.id;
    L16:
        return r2.cq(r5, r8, r7, r6);
    L11:
        r8 = null;
        goto L12
    L20:
        return true;
    L19:
        return true;
    L17:
        return true;
    }

    public void b(Fragment r11, boolean r12, z r13, Message r14, i r15, ChatParam r16, int r17, boolean r18, Boolean r19, f r20, kc8.q r21) {
        Intrinsics.checkNotNullParameter(r14, "message");
        Intrinsics.checkNotNullParameter(r15, "blockModel");
        if (this.b == false) goto L8;
        this.b = false;
        LifecycleRegistry r3 = new LifecycleRegistry(this);
        this.c = r3;
        r3.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        LifecycleRegistry r4 = this.c;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r4 = null;
    L7:
        r4.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L8:
        this.d = r11;
        this.e = r14;
        this.g = r16;
        this.j = r15;
        this.i = r12;
        this.h = r18;
        this.k = r19;
        this.l = r20;
        this.f = r21;
        BlockContent r1 = ((jc8.a) r15).a.getContent();
        if (r1 == null) goto L71;
        CreationBlock r2 = r1.getCreationBlock();
        if (r2 == null) goto L71;
        List r5 = r2.creations;
        if (r5 == null) goto L71;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L16:
        if (r7.hasNext() == false) goto L72;
        Object r8 = r7.next();
        CreationItem r9 = (CreationItem) r8;
        Integer r10 = r9.type;
        boolean r22 = true;
        if (r10 != null) goto L21;
    L42:
        Integer r23 = r9.type;
        if (r23 != null) goto L46;
    L57:
        VideoData r24 = r9.video;
        if (r24 == null) goto L65;
        Integer r25 = r24.status;
        if (r25 == null) goto L65;
        if (r25.intValue() != 4) goto L65;
        boolean r26 = true;
    L66:
        if (r26 == true) goto L69;
        r22 = false;
    L69:
        if (r22 == false) goto L16;
        r6.add(r8);
    L65:
        r26 = false;
        goto L66
    L46:
        if (r23.intValue() != 2) goto L57;
        VideoData r27 = r9.video;
        if (r27 == null) goto L55;
        Integer r28 = r27.status;
        if (r28 == null) goto L55;
        if (r28.intValue() != 3) goto L55;
        boolean r29 = true;
    L56:
        if (r29 == true) goto L69;
    L55:
        r29 = false;
        goto L56
    L21:
        if (r10.intValue() != 1) goto L42;
        ImageData r30 = r9.image;
        if (r30 == null) goto L30;
        Integer r31 = r30.status;
        if (r31 == null) goto L30;
        if (r31.intValue() != 2) goto L30;
        boolean r32 = true;
    L31:
        if (r32 == true) goto L69;
        ImageData r33 = r9.image;
        if (r33 == null) goto L40;
        Integer r34 = r33.status;
        if (r34 == null) goto L40;
        if (r34.intValue() != 1) goto L40;
        boolean r35 = true;
    L41:
        if (r35 == true) goto L69;
    L40:
        r35 = false;
    L30:
        r32 = false;
    L72:
        this.m = r6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AbsCreationBlockView$bindObservers$1(this, null), 2, null);
        return;
    L71:
        r6 = null;
        goto L72
    }
}
