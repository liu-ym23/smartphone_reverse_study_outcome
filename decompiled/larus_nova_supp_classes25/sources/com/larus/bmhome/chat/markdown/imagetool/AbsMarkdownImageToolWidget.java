package com.larus.bmhome.chat.markdown.imagetool;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import po8.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001jB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ[\u0010E\u001a\u00020F2\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010G\u001a\u00020H2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010I\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010*¢\u0006\u0002\u0010JJ\u001f\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010,2\b\u0010N\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u0004\u0018\u00010,J\b\u0010Q\u001a\u00020\u0010H\u0004J!\u0010R\u001a\u00020L2\b\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u00100\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0002\u0010SJ\u0010\u0010T\u001a\u00020L2\u0006\u0010U\u001a\u00020VH\u0014J\b\u0010W\u001a\u00020XH$J\u0010\u0010Y\u001a\u00020L2\u0006\u0010G\u001a\u00020HH$J\b\u0010Z\u001a\u00020LH\u0014J\b\u0010[\u001a\u00020\u0010H&J\b\u0010\u0018\u001a\u00020\u0010H&J\b\u0010\"\u001a\u00020#H&J\n\u0010\\\u001a\u0004\u0018\u00010,H\u0016J\b\u0010]\u001a\u00020LH\u0002J\b\u0010^\u001a\u00020LH\u0002J\u001f\u0010_\u001a\u00020L2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0002\u0010`J\u0019\u0010a\u001a\u00020L2\n\b\u0001\u0010I\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020\u0010H\u0016J\b\u0010d\u001a\u00020LH\u0002J\u0017\u0010e\u001a\u00020L2\b\u0010I\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0002\u0010bJ\b\u0010f\u001a\u00020LH\u0002J\b\u0010g\u001a\u00020LH\u0002J\b\u0010h\u001a\u00020LH\u0016J\u0006\u0010i\u001a\u00020LR\u001e\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?R\u001b\u0010B\u001a\u00020\u00108DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bD\u0010A\u001a\u0004\bC\u0010\u0011¨\u0006k"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagetool/AbsMarkdownImageToolWidget;", "T", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isFold", "", "()Z", "setFold", "(Z)V", "isUserClick", "searching", "getSearching", "setSearching", "hasImage", "getHasImage", "setHasImage", "thinkFoldStatus", "Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "getThinkFoldStatus", "()Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "setThinkFoldStatus", "(Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;)V", "haveReportCardShow", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "getToolType", "()Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "setToolType", "(Lcom/larus/bmhome/chat/markdown/reference/ToolType;)V", "disableFoldExpandClick", "interceptClickCard", "Lkotlin/Function0;", "configuredDataIdentifier", "", "configuredInitialFoldState", "Ljava/lang/Boolean;", "shouldApplyInitialFoldState", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "getMarkdownCommonInputData", "()Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "setMarkdownCommonInputData", "(Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;)V", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "getBlockDependConfig", "()Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "setBlockDependConfig", "(Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;)V", "toolHeader", "Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "getToolHeader", "()Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "toolHeader$delegate", "Lkotlin/Lazy;", "showZoomInAnim", "getShowZoomInAnim", "showZoomInAnim$delegate", "bindData", "Landroid/util/Size;", "maxWidth", "", "backgroundResource", "(Ljava/lang/Object;ILcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;Lkotlin/jvm/functions/Function0;)Landroid/util/Size;", "configureInitialFoldState", "", "dataIdentifier", "initialFoldState", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "currentToolTitle", "canRenderExpandedContent", "initData", "(Ljava/lang/Object;Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;)V", "setToolHeaderLayoutParams", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "onToolHeaderData", "Lcom/larus/bmhome/chat/markdown/imagetool/AbsMarkdownImageToolWidget$ToolHeaderData;", "refreshImageView", "initExtraData", "isSearching", "toolName", "initFoldStatus", "initStatusData", "refreshWidgetUI", "(ILjava/lang/Integer;)V", "refreshToolHeader", "(Ljava/lang/Integer;)V", "shouldHide", "onClick", "showWidgetBg", "mobShowCard", "mobClickCard", "onViewRecycled", "onRecycle", "ToolHeaderData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class AbsMarkdownImageToolWidget<T> extends FrameLayout {
    public static final /* synthetic */ int r = 0;
    public T a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public DeepThinkFoldStatus f;
    public boolean g;
    public ToolType h;
    public boolean i;
    public Function0<Boolean> j;
    public String k;
    public Boolean l;
    public boolean m;
    public fh8.f n;
    public kc8.b o;
    public final Lazy p;
    public final Lazy q;

    public static final class a {
        public final List<String> a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ToolHeaderData(searchingTitle=" + this.a + ", searchedTitle=" + this.b + ", iconUrl=" + this.c + ", iconUrlDark=" + this.d + ')';
        }

        public a(List<String> r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "searchingTitle");
            Intrinsics.checkNotNullParameter(r3, "searchedTitle");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public abstract boolean b();

    public void c() {
    }

    public abstract boolean d();

    public abstract a f();

    public void g() {
        this.c = false;
        this.g = false;
        this.f = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.i = false;
        this.j = null;
        z r0 = getToolHeader().c;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        removeAllViews();
    }

    public abstract void h(int r1);

    public String j() {
        return null;
    }

    public abstract ToolType k();

    public void setToolHeaderLayoutParams(FrameLayout.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutParams");
    }

    private final DeepThinkCommonToolHeader getToolHeader() {
        return (DeepThinkCommonToolHeader) this.p.getValue();
    }

    public final void e() {
        fh8.f r0 = this.n;
        if (r0 == null) goto L17;
        Message r3 = r0.b;
        if (r3 == null) goto L18;
        int r1 = g.a;
        if (r0 == null) goto L9;
        String r2 = r0.d;
    L10:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        String r4 = r2;
        String r5 = j();
        if (r5 != null) goto L15;
        r5 = this.h.getValue();
    L15:
        String r6 = r5;
        boolean r7 = this.b;
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "botId");
        Intrinsics.checkNotNullParameter(r6, "toolName");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ImageToolWidgetEventUtils$mobClickCard$1(r7, r3, r4, r6, null), 3, null);
        return;
    L9:
        r2 = null;
        goto L10
    L18:
        return;
    }

    public final boolean getShowZoomInAnim() {
        return ((Boolean) this.q.getValue()).booleanValue();
    }

    public boolean i() {
        if (this.a != null) goto L5;
        return true;
    L5:
        fh8.f r0 = this.n;
        if (r0 == null) goto L10;
        Message r1 = r0.b;
        if (r1 == null) goto L10;
        Integer r2 = Integer.valueOf(r1.getMessageStatusLocal());
    L12:
        if (r2 != null) goto L15;
    L16:
        if (r2 != null) goto L19;
    L21:
        boolean r3 = false;
    L24:
        if (this.d == false) goto L27;
        if (r3 == false) goto L27;
        return true;
    L27:
        return false;
    L19:
        if (r2.intValue() != 22) goto L21;
    L22:
        r3 = true;
        goto L24
    L15:
        if (r2.intValue() == 23) goto L22;
    L10:
        r2 = null;
        goto L12
    }

    public final kc8.b getBlockDependConfig() {
        return this.o;
    }

    public final T getData() {
        return this.a;
    }

    public final boolean getHasImage() {
        return this.e;
    }

    public final fh8.f getMarkdownCommonInputData() {
        return this.n;
    }

    public final boolean getSearching() {
        return this.d;
    }

    public final DeepThinkFoldStatus getThinkFoldStatus() {
        return this.f;
    }

    public final ToolType getToolType() {
        return this.h;
    }

    public AbsMarkdownImageToolWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setBlockDependConfig(kc8.b r1) {
        this.o = r1;
    }

    public final void setData(T r1) {
        this.a = r1;
    }

    public final void setFold(boolean r1) {
        this.b = r1;
    }

    public final void setHasImage(boolean r1) {
        this.e = r1;
    }

    public final void setMarkdownCommonInputData(fh8.f r1) {
        this.n = r1;
    }

    public final void setSearching(boolean r1) {
        this.d = r1;
    }

    public final void setThinkFoldStatus(DeepThinkFoldStatus r1) {
        this.f = r1;
    }

    public final void setToolType(ToolType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public AbsMarkdownImageToolWidget(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = true;
        this.h = ToolType.SearchImage;
        this.p = LazyKt.lazy(new com.larus.bmhome.chat.markdown.imagetool.a(r2, this));
        this.q = LazyKt.lazy(new b());
    }

    public final Size a(T r14, int r15, fh8.f r16, Integer r17, Boolean r18, kc8.b r19, Function0<Boolean> r20) {
        this.o = r19;
        Boolean r2 = Boolean.TRUE;
        this.i = Intrinsics.areEqual(r18, r2);
        this.j = r20;
        this.a = r14;
        this.n = r16;
        fh8.c r1 = r16.k;
        if (r1 == null) goto L7;
        fh8.d r3 = r1.a;
        if (r3 == null) goto L7;
        DeepThinkFoldStatus r4 = r3.a();
    L8:
        Boolean r5 = this.l;
        boolean r6 = false;
        if (r5 == null) goto L13;
        this.f = r4;
        if (this.m == false) goto L28;
        this.b = Intrinsics.areEqual(r5, r2);
        this.c = false;
        this.m = false;
    L28:
        this.e = b();
        this.h = k();
        this.d = d();
        c();
        if (i() == false) goto L34;
        z r7 = getToolHeader().c;
        if (r7 == null) goto L33;
        r7.b();
    L33:
        e1.o(this);
    L83:
        return new Size(-1, -2);
    L34:
        e1.x(this);
        if (getToolHeader().getParent() != null) goto L37;
        addView(getToolHeader());
    L37:
        a r8 = f();
        if (this.d == false) goto L41;
        getToolHeader().c(r8.a);
    L51:
        DeepThinkCommonToolHeader r9 = getToolHeader();
        ToolType r10 = this.h;
        if (this.d == false) goto L54;
    L57:
        r6 = true;
    L58:
        r9.b(r10, r6, r8.c, r8.d);
        if (r17 == null) goto L61;
        int r11 = r17.intValue();
    L62:
        getToolHeader().setBackgroundResource(r11);
        if (this.d == false) goto L65;
    L81:
        h(r15);
        goto L83
    L65:
        if (this.f == DeepThinkFoldStatus.CompleteFold) goto L81;
        if (this.g == true) goto L81;
        this.g = true;
        fh8.f r12 = this.n;
        if (r12 == null) goto L81;
        Message r13 = r12.b;
        if (r13 == null) goto L81;
        int r21 = g.a;
        String r22 = r12.d;
        if (r22 != null) goto L77;
        r22 = "";
    L77:
        String r23 = r22;
        String r24 = j();
        if (r24 != null) goto L80;
        r24 = this.h.getValue();
    L80:
        String r25 = r24;
        boolean r26 = this.b;
        Intrinsics.checkNotNullParameter(r13, "message");
        Intrinsics.checkNotNullParameter(r23, "botId");
        Intrinsics.checkNotNullParameter(r25, "toolName");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ImageToolWidgetEventUtils$mobShowCard$1(r26, r13, r23, r25, null), 3, null);
        goto L81
    L61:
        r11 = v19.c.b(2130970716, null, 2131239260);
        goto L62
    L54:
        if (this.e == false) goto L57;
        if (this.i == false) goto L58;
    L41:
        if (this.e == true) goto L43;
    L45:
        boolean r27 = false;
    L46:
        DeepThinkCommonToolHeader r28 = getToolHeader();
        ToolType r29 = this.h;
        String r30 = r8.b;
        boolean r110 = this.b;
        Boolean r111 = Boolean.valueOf(this.i);
        if (r27 == false) goto L49;
        Function0 r112 = new c(this);
    L50:
        r28.d(r29, r30, r110, r111, r112);
        goto L51
    L49:
        r112 = null;
        goto L50
    L43:
        if (this.i == true) goto L45;
        r27 = true;
        goto L46
    L13:
        this.m = false;
        DeepThinkFoldStatus r31 = this.f;
        if (r4 == r31) goto L22;
        this.f = r4;
        this.c = false;
        if (r4 != DeepThinkFoldStatus.CompleteExpand) goto L19;
        this.b = false;
        goto L28
    L19:
        if (r4 != DeepThinkFoldStatus.HalfFold) goto L28;
        this.b = true;
        goto L28
    L22:
        if (this.c == true) goto L28;
        if (r31 == DeepThinkFoldStatus.CompleteExpand) goto L26;
        boolean r32 = true;
    L27:
        this.b = r32;
        goto L28
    L26:
        r32 = false;
    L7:
        r4 = null;
        goto L8
    }
}
