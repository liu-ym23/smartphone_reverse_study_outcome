package com.obric.memorydata.markdown.custom;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.az;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.q;
import com.obric.oui.button.OButton;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0003)*+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u001f\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0018\u0010 \u001a\u00020\u00162\b\b\u0001\u0010!\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u001e\u001a\u00020\u00162\b\b\u0001\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010$\u001a\u00020\u0016H\u0002J\u0006\u0010%\u001a\u00020\u0016J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/markdown/custom/OMenuDialog;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "actionDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "titleMaxWidth", "", "title", "", "onClickListener", "Landroid/view/View$OnClickListener;", "adapter", "Lcom/obric/memorydata/markdown/custom/OMenuDialog$Adapter;", "show", "", "genContentView", "Landroid/view/View;", "setAdapter", "titles", "", "listeners", "setTitle", "setNegativeButton", "setOnDismissListener", "setPositiveButton", "resId", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "clearSelfFromCurrent", "dismiss", "isShowing", "", "hide", "Companion", "Adapter", "Item", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9988a = null;
    private static WeakReference<h> j;
    private static final Object k = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f9989b;
    private final WeakReference<Activity> c;
    private DialogInterface.OnDismissListener d;
    private com.obric.oui.dialog.v2.action.a e;
    private int f;
    private String g;
    private View.OnClickListener h;
    private a i;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\u0004\b\u000b\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/markdown/custom/OMenuDialog$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/memorydata/markdown/custom/OMenuDialog$Adapter$ViewHolder;", "context", "Landroid/content/Context;", "items", "", "Lcom/obric/memorydata/markdown/custom/OMenuDialog$Item;", "dismiss", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "titles", "", "listeners", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "ViewHolder", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends RecyclerView.Adapter<C0485a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f9990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<c> f9991b;
        private final Function0<Unit> c;

        /* JADX INFO: renamed from: com.obric.memorydata.markdown.custom.h$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/markdown/custom/OMenuDialog$Adapter$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0485a extends RecyclerView.v {
            public C0485a(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
            }
        }

        public a(Context r3, List<c> r4, Function0<Unit> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            List<c> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r7, "items");
            this.f9990a = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            this.f9991b = r7;
            this.c = r8;
        }

        private static final OButton a(Context r8, int r9, int r10) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "styledContext");
            OButton r11 = new OButton(r1, null, 0, 0, null, 28, null);
            r11.setLayoutParams(new ViewGroup.LayoutParams(-1, r10));
            r11.setMaxLines(1);
            return r11;
        }

        private static final void a(c r0, a r1, View r2) {
            r0.b().onClick(r2);
            Function0<Unit> r3 = r1.c;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }

        public static /* synthetic */ void lambda$nwEgHvsioGexkJmECs85adG3_VA(c r0, a r1, View r2) {
            a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$wObP92KI314y-gUiOCjda4ZnjS4, reason: not valid java name */
        public static /* synthetic */ OButton m680lambda$wObP92KI314ygUiOCjda4ZnjS4(Context r0, int r1, int r2) {
            return a(r0, r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int a(int r2) {
            return ((c) ZeusTransformUtils.preCheckCast(this.f9991b.get(r2), c.class, "com.obric.memorydata.plugin")).c();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
        }

        public void a(C0485a r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "holder");
            final c r11 = (c) ZeusTransformUtils.preCheckCast(this.f9991b.get(r10), c.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OMenuDialog", "title: " + q.f13259a.b(r11.a()) + ", contains '\\n': " + StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.memorydata.plugin"), '\n', false, 2, null), false, 4, null);
            View r12 = r9.c;
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.obric.oui.button.OButton");
            OButton r13 = (OButton) ZeusTransformUtils.preCheckCast(r12, OButton.class, "com.obric.memorydata.plugin");
            r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r11.a(), "\n", "", false, 4, null), CharSequence.class, "com.obric.memorydata.plugin"));
            r13.setMaxLines(1);
            r13.setEllipsize(TextUtils.TruncateAt.END);
            r13.setOnClickListener(new $$Lambda$h$a$nwEgHvsioGexkJmECs85adG3_VA(r11, this));
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* synthetic */ void a(RecyclerView.v r3, int r4) {
            a((C0485a) ZeusTransformUtils.preCheckCast(r3, C0485a.class, "com.obric.memorydata.plugin"), r4);
        }

        public C0485a b(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            return new C0485a((View) ZeusTransformUtils.preCheckCast((OButton) ZeusTransformUtils.preCheckCast(com.obric.oui.c.e.a(this.f9990a, r3, $$Lambda$h$a$wObP92KI314ygUiOCjda4ZnjS4.INSTANCE), OButton.class, "com.obric.memorydata.plugin"), View.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int d() {
            return this.f9991b.size();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/markdown/custom/OMenuDialog$Companion;", "", "<init>", "()V", "TAG", "", "currentDialogRef", "Ljava/lang/ref/WeakReference;", "Lcom/obric/memorydata/markdown/custom/OMenuDialog;", "lock", "currentDialog", "getCurrentDialog", "()Lcom/obric/memorydata/markdown/custom/OMenuDialog;", "dismissCurrent", "", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/markdown/custom/OMenuDialog$Item;", "", "title", "", "listener", "Landroid/view/View$OnClickListener;", "buttonStyle", "", "centerText", "", "<init>", "(Ljava/lang/String;Landroid/view/View$OnClickListener;IZ)V", "getTitle", "()Ljava/lang/String;", "getListener", "()Landroid/view/View$OnClickListener;", "getButtonStyle", "()I", "getCenterText", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View.OnClickListener f9993b;
        private final int c;
        private final boolean d;

        public c(String r3, View.OnClickListener r4, int r5, boolean r6) {
            View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r7, "listener");
            this.f9992a = r3;
            this.f9993b = r7;
            this.c = r5;
            this.d = r6;
        }

        public /* synthetic */ c(String r2, View.OnClickListener r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
            View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
            if ((r6 & 4) == 0) goto L6;
            r4 = ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Neutral, "style", "OStyleV2_OButton_L_Standard_Neutral");
        L6:
            if ((r6 & 8) == 0) goto L8;
            r5 = false;
        L8:
            this(r2, r8, r4, r5);
        }

        public final String a() {
            return this.f9992a;
        }

        public final View.OnClickListener b() {
            return this.f9993b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9992a, r6.f9992a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9993b, r6.f9993b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f9992a.hashCode() * 31) + this.f9993b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "Item(title=" + this.f9992a + ", listener=" + this.f9993b + ", buttonStyle=" + this.c + ", centerText=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/markdown/custom/OMenuDialog$genContentView$recyclerView$1$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends RecyclerView.g {
        d() {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r1, View r2, RecyclerView r3, RecyclerView.s r4) {
            Intrinsics.checkNotNullParameter(r1, "outRect");
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "parent");
            Intrinsics.checkNotNullParameter(r4, "state");
            if (r3.getChildAdapterPosition(r2) != 0) goto L5;
            int r0 = 0;
        L6:
            r1.top = r0;
            return;
        L5:
            r0 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
            goto L6
        }
    }

    static {
        f9988a = new b(null);
        k = new Object();
    }

    public h(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Context r11 = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.f9989b = r11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OMenuDialog", "activity: " + ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r11), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")), false, 4, null);
        this.c = new WeakReference((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r11), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"));
        this.h = new $$Lambda$h$jR3lnCbb_DN3SbtI22lnk7ecnOI(this);
    }

    private static final View a(h r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1.d();
    }

    private static final Unit a(h r0) {
        r0.b();
        return Unit.INSTANCE;
    }

    private static final void a(h r2, DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        r2.e();
        DialogInterface.OnDismissListener r5 = r2.d;
        if (r5 == null) goto L6;
        r5.onDismiss(r4);
        return;
    }

    private static final void a(h r0, View r1) {
        com.obric.oui.dialog.v2.action.a r2 = r0.e;
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }

    private final View d() {
        RecyclerView r0 = new RecyclerView(this.f9989b);
        r0.setOverScrollMode(0);
        r0.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r0.setVerticalScrollBarEnabled(false);
        r0.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new d(), RecyclerView.g.class, "com.obric.memorydata.plugin"));
        r0.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(this.i, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    private final void e() {
        Object r0 = k;
        monitor-enter(r0);
        WeakReference<h> r1 = j;     // Catch: Throwable -> L13
        if (r1 == null) goto L7;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r1.get(), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L8:
        if (r2 != this) goto L10;
        j = null;     // Catch: Throwable -> L13
    L10:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L7:
        r2 = null;
    L13:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Unit lambda$JZwlDm2MWrbY2djtdQIj1HRdtl8(h r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$PpjDc_Ma2pNWJAYbAPFW9gBI8Y4(h r0, DialogInterface r1) {
        a(r0, r1);
    }

    public static /* synthetic */ View lambda$TWm8cPmUnk_bFqOImyDCRlcQj3o(h r0, ViewGroup r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$jR3lnCbb_DN3SbtI22lnk7ecnOI(h r0, View r1) {
        a(r0, r1);
    }

    public final void a() {
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.c.get(), Activity.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L45:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OMenuDialog", "Activity is invalid, skip show()", null, 4, null);
        return;
    L5:
        if (r0.isFinishing() == true) goto L45;
        if (r0.isDestroyed() == true) goto L45;
        Object r1 = k;
        monitor-enter(r1);
        WeakReference<h> r2 = j;     // Catch: Throwable -> L42
        if (r2 == null) goto L14;
        h r3 = (h) ZeusTransformUtils.preCheckCast(r2.get(), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
    L15:
        if (r3 == this) goto L17;
    L20:
        if (r3 == null) goto L30;
        Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(r3.c.get(), Activity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r4 == null) goto L30;
        if (r4.isFinishing() == true) goto L30;
        if (r4.isDestroyed() == true) goto L30;
        com.obric.oui.dialog.v2.action.a r5 = r3.e;     // Catch: Throwable -> L42
        if (r5 == null) goto L30;
        r5.dismiss();     // Catch: Throwable -> L42
    L30:
        j = new WeakReference(this);     // Catch: Throwable -> L42
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r1);
        String r7 = this.g;
        if (r7 != null) goto L35;
        r7 = "";
    L35:
        com.obric.oui.dialog.v2.action.a.b r8 = new com.obric.oui.dialog.v2.action.a.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$h$TWm8cPmUnk_bFqOImyDCRlcQj3o(this));
        com.obric.oui.dialog.v2.action.a r9 = new com.obric.oui.dialog.v2.action.a(this.f9989b, r8);
        this.e = r9;
        if (r9 == null) goto L38;
        r9.setOnDismissListener(new $$Lambda$h$PpjDc_Ma2pNWJAYbAPFW9gBI8Y4(this));
    L38:
        com.obric.oui.dialog.v2.action.a r10 = this.e;
        if (r10 == null) goto L49;
        r10.show();
        return;
    L49:
        return;
    L17:
        if (c() == false) goto L20;
        monitor-exit(r1);
        return;
    L14:
        r3 = null;
    L42:
        th = move-exception;
        throw th;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "title");
        this.g = az.c(r3);
        this.f = MathKt.roundToInt(TypedValue.applyDimension(1, 200, Resources.getSystem().getDisplayMetrics()));
    }

    public final void a(List<String> r3, List<? extends View.OnClickListener> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "titles");
        Intrinsics.checkNotNullParameter(r6, "listeners");
        this.i = new a(this.f9989b, i.a(r5, r6), new $$Lambda$h$JZwlDm2MWrbY2djtdQIj1HRdtl8(this));
    }

    public final void b() {
        e();
        com.obric.oui.dialog.v2.action.a r0 = this.e;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.e = null;
    }

    public final boolean c() {
        com.obric.oui.dialog.v2.action.a r0 = this.e;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isShowing();
    }
}
