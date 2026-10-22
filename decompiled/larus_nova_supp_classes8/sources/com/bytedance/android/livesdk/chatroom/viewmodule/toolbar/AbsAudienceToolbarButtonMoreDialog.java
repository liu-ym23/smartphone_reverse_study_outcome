package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IFloatWindowDegradeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00020\u00070\u00062\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AbsAudienceToolbarButtonMoreDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/d2;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/s;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/e;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/b2;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsAudienceToolbarButtonMoreDialog extends CommonStandardBottomDialog implements View.OnClickListener, d2, Observer<KVData>, s<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e>, b2 {
    public final String B;
    public final ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> C;
    public ToolbarDisableController D;
    public final TreeSet<RedDotDelegate> E;
    public DataCenter F;
    public final ArrayList<Pair<ViewGroup, Integer>> G;
    public RecyclerView H;
    public x3 I;
    public final CompositeDisposable J;
    public MorePanelButtonDiffUpdater<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> K;
    public boolean L;
    public final Lazy M;
    public final a N;
    public String O;
    public final float P;

    public static final class a implements com.bytedance.android.live.room.api.panel.b {
        public final /* synthetic */ AbsAudienceToolbarButtonMoreDialog a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog$a$a, reason: collision with other inner class name */
        public static final class RunnableC0057a implements Runnable {
            public final /* synthetic */ View a;
            public final /* synthetic */ Function1 b;

            public RunnableC0057a(View r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.invoke(Integer.valueOf(this.a.getHeight()));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final int getUnionId() {
            return hashCode();
        }

        public final PanelName getPanelName() {
            return PanelName.More;
        }

        public a(AbsAudienceToolbarButtonMoreDialog r1) {
            this.a = r1;
        }

        public final void a(Function1<? super Integer, Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "continueAction");
            Intrinsics.checkNotNullParameter(r4, "stopAction");
            AbsAudienceToolbarButtonMoreDialog r0 = this.a;
            r0.getClass();
            View r1 = r0.findViewById(2131389519);
            if (r1 == null) goto L5;
            r1.post(new RunnableC0057a(r1, r3));
            return;
        L5:
            r4.invoke("rootView is null");
        }
    }

    public void X0(ExtendedToolbarButton r2, c0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "behavior");
    }

    public final jp1.c a1() {
        return (jp1.c) this.M.getValue();
    }

    public abstract x3 b1();

    public void g1() {
    }

    public void h1() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void f1() {
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r1 = this.C;
        jp1.c r2 = a1();
        if (r2 == null) goto L5;
        r2.b(r1);
    L5:
        ALogger.i(this.B, "isPaused:" + c1());
        x3 r3 = this.I;
        if (r3 == null) goto L16;
        if (c1() == false) goto L12;
        ArrayList<ExtendedToolbarButton> r4 = Y0(r1);
        ToolbarDisableController r5 = this.D;
        if (r5 == null) goto L16;
        r5.a(r3, r4, AbsAudienceToolbarButtonMoreDialog$adaptiveToolbarsDisable$1$1.INSTANCE);
        goto L16
    L12:
        ToolbarDisableController r6 = this.D;
        if (r6 == null) goto L16;
        r6.b(r3);
    L16:
        if (this.G.isEmpty() == false) goto L19;
        return;
    L19:
        if (c4.a(false) == false) goto L21;
        this.E.clear();
        RedDotHelper.b(Y0(r1), this.I, this.E);
    L21:
        MorePanelButtonDiffUpdater<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r7 = this.K;
        if (r7 == null) goto L102;
        Intrinsics.checkNotNullParameter(r1, "buttons");
        ArrayList r8 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r9 = r1.iterator();
    L24:
        boolean r10 = true;
        if (r9.hasNext() == false) goto L32;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r11 = r9.next();
        if (r11.getGroupType() == 1) goto L30;
        r10 = false;
    L30:
        if (r10 == false) goto L24;
        r8.add(r11);
        goto L24
    L32:
        RecyclerView r12 = r7.b;
        if (r12 != null) goto L36;
    L46:
        HashMap r13 = new HashMap();
        Iterator<T> r14 = r7.a.iterator();
    L48:
        if (r14.hasNext() == false) goto L72;
        Pair r15 = (Pair) r14.next();
        ViewGroup r16 = (ViewGroup) r15.getFirst();
        ArrayList r17 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r18 = r1.iterator();
    L51:
        if (r18.hasNext() == false) goto L58;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r19 = r18.next();
        if (r19.getGroupType() != ((Number) r15.getSecond()).intValue()) goto L55;
        boolean r110 = true;
    L56:
        if (r110 == false) goto L51;
        r17.add(r19);
        goto L51
    L55:
        r110 = false;
        goto L56
    L58:
        int r20 = r16.getChildCount();
        int r111 = 0;
    L59:
        if (r111 >= r20) goto L48;
        View r112 = r16.getChildAt(r111);
        Iterator r113 = r17.iterator();
    L62:
        if (r113.hasNext() == false) goto L67;
        Object r114 = r113.next();
        if (Intrinsics.areEqual((com.bytedance.android.livesdk.chatroom.e) r114, r112.getTag()) == false) goto L62;
    L68:
        com.bytedance.android.livesdk.chatroom.e r115 = (com.bytedance.android.livesdk.chatroom.e) r114;
        if (r115 == null) goto L71;
        View r21 = (View) r13.put(r115, r112);
    L71:
        r111 = r111 + 1;
        goto L59
    L67:
        r114 = null;
        goto L68
    L72:
        Iterator<T> r22 = r7.a.iterator();
    L74:
        if (r22.hasNext() == false) goto L76;
        ((ViewGroup) ((Pair) r22.next()).getFirst()).removeAllViews();
        goto L74
    L76:
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r23 = r1.iterator();
    L78:
        if (r23.hasNext() == false) goto L102;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r24 = r23.next();
        Iterator<T> r25 = r7.a.iterator();
    L81:
        if (r25.hasNext() == false) goto L88;
        Object r26 = r25.next();
        if (((Number) ((Pair) r26).getSecond()).intValue() != r24.getGroupType()) goto L85;
        boolean r27 = true;
    L86:
        if (r27 == false) goto L81;
    L89:
        Pair r28 = (Pair) r26;
        if (r28 == null) goto L92;
        ViewGroup r29 = (ViewGroup) r28.getFirst();
    L93:
        if (r29 == null) goto L78;
        View r30 = (View) r13.get(r24);
        if (r30 == null) goto L97;
    L101:
        r29.addView(r30);
        goto L78
    L97:
        if (com.bytedance.android.livesdk.config.setting.o.b() == false) goto L99;
        float r31 = 5.0f;
    L100:
        r30 = r7.c.x(r29, r31, r24);
        r7.c.o(null, r24, r30, 0);
        goto L101
    L99:
        r31 = 4;
        goto L100
    L92:
        r29 = null;
        goto L93
    L85:
        r27 = false;
        goto L86
    L88:
        r26 = null;
        goto L89
    L36:
        if (r12.getAdapter() != null) goto L38;
        r12.setAdapter(new MorePanelButtonDiffUpdater.DynamicItemAdapter(r7));
    L38:
        RecyclerView.Adapter r32 = r12.getAdapter();
        if ((r32 instanceof MorePanelButtonDiffUpdater.DynamicItemAdapter) == true) goto L41;
        r32 = null;
    L41:
        MorePanelButtonDiffUpdater.DynamicItemAdapter r33 = (MorePanelButtonDiffUpdater.DynamicItemAdapter) r32;
        if (r33 == null) goto L44;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r33.a = r8;
    L44:
        if (r33 == null) goto L46;
        r33.notifyDataSetChanged();
    L102:
        g1();
    }

    public final int Z0() {
        Iterator<T> r0 = this.G.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L15;
        Pair r3 = (Pair) r0.next();
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r4 = this.C;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        Object r7 = r6.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r7).i != ((Number) r3.getSecond()).intValue()) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L7;
        r5.add(r7);
        goto L7
    L11:
        r8 = false;
        goto L12
    L14:
        r2 = Math.max(r5.size(), r2);
        goto L4
    L15:
        return r2;
    }

    public final boolean c1() {
        DataCenter r0 = this.F;
        zg1.m r1 = null;
        if (r0 == null) goto L5;
        r1 = (zg1.m) r0.get("data_broadcast_pause_state", null);
    L5:
        if (r1 == null) goto L11;
        int r2 = r1.a;
        if (r2 != 1) goto L9;
        return true;
    L9:
        if (r2 != 2) goto L11;
        return true;
    L11:
        return false;
    }

    public void i1() {
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r0 = this.C.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r1 = r0.next();
        x3 r2 = this.I;
        if (r2 == null) goto L8;
        c0.b r3 = r2.s(r1.m);
    L10:
        if ((r3 instanceof n) == false) goto L4;
        ((n) r3).onShow();
        goto L4
    L8:
        r3 = null;
        goto L10
    L12:
        DataCenter r4 = this.F;
        if (r4 == null) goto L15;
        r4.observe("cmd_live_toolbarmore_dialog_dismiss", this);
    L15:
        xs2.b r5 = xs2.b.a();
        ds0.b r6 = new ds0.b();
        r6.a(LivePanelType.TOOL_BAR_MORE);
        Intrinsics.checkNotNullParameter("open", "<set-?>");
        r6.b = "open";
        WeakReference r7 = new WeakReference(this);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.d = r7;
        r6.e = 2131389519;
        Unit r8 = Unit.INSTANCE;
        r5.post(r6);
        int r9 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r10 = com.bytedance.android.live.room.api.panel.d.c(this.F, 2);
        if (r10 == null) goto L24;
        r10.notifyPanelOpen(PanelName.More, this.N);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void j() {
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r0 = this.C;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r3).i != 3) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        Iterator r5 = r1.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        s<Object> r6 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r5.next()).k;
        if (r6 == null) goto L13;
        r6.j();
        goto L13
    }

    public void onDetachedFromWindow() {
        this.J.clear();
        DataCenter r0 = this.F;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        j();
        IFloatWindowDegradeManager r1 = jc1.k.f(IFloatWindowDegradeManager.class);
        if (r1 == null) goto L8;
        r1.checkRecoverForNative("more_panel", "dismiss");
    L8:
        Iterator<T> r2 = this.C.iterator();
    L10:
        if (r2.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r2.next();
        x3 r4 = this.I;
        if (r4 == null) goto L14;
        c0.b r5 = r4.s(r3.m);
    L15:
        if (r5 == null) goto L10;
        r5.Y6();
        goto L10
    L14:
        r5 = null;
        goto L15
    L17:
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        jp1.c r1 = a1();
        if (r1 == null) goto L20;
        r1.release();
    L20:
        com.bytedance.android.livesdk.f.d().g("MORE");
        xs2.b r2 = xs2.b.a();
        ds0.b r3 = new ds0.b();
        r3.a(LivePanelType.TOOL_BAR_MORE);
        Intrinsics.checkNotNullParameter("close", "<set-?>");
        r3.b = "close";
        Unit r4 = Unit.INSTANCE;
        r2.post(r3);
        int r5 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r6 = com.bytedance.android.live.room.api.panel.d.c(this.F, 2);
        if (r6 == null) goto L29;
        r6.notifyPanelClose(PanelName.More, this.N);
        return;
    L29:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r7 == null) goto L16;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.L = false;
        DataCenter r0 = this.F;
        if (r0 == null) goto L5;
        int r1 = z3.a;
        z3.c(r0, !((SheetBaseDialog) this).r);
    L5:
        f1();
        IFloatWindowDegradeManager r2 = jc1.k.f(IFloatWindowDegradeManager.class);
        if (r2 == null) goto L9;
        r2.checkDegradeForNative("more_panel");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().b("MORE", this);
        i1();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final void c() {
        W0(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final CompositeDisposable getCompositeDisposable() {
        return this.J;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final DataCenter getDataCenter() {
        return this.F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void W0(AbsAudienceToolbarButtonMoreDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final ArrayList<ExtendedToolbarButton> Y0(List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r3) {
        ArrayList<ExtendedToolbarButton> r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r4.next()).m);
        goto L4
    L6:
        return r0;
    }

    public final boolean e1(ToolbarButton r4) {
        Intrinsics.checkNotNullParameter(r4, "toolbarButton");
        Iterator<T> r0 = this.C.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ExtendedToolbarButton r1 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r0.next()).m;
        if ((r1 instanceof ExtendedToolbarButton.b) == false) goto L4;
        if (((ExtendedToolbarButton.b) r1).i != r4) goto L4;
        return true;
    L11:
        return false;
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3.getKey(), "cmd_live_toolbarmore_dialog_dismiss") == false) goto L9;
        W0(this);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        Object r0 = null;
        String r1 = null;
        String r2 = null;
        if (r8 == null) goto L5;
        Object r3 = r8.getTag();
    L7:
        if ((r3 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == true) goto L9;
        r3 = null;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r3;
        if (r4 == null) goto L12;
        ExtendedToolbarButton r5 = r4.m;
    L13:
        if (r5 != null) goto L15;
        return;
    L15:
        if (c1() == false) goto L22;
        x3 r6 = this.I;
        if (r6 == null) goto L22;
        if (r6.x(r5) != true) goto L22;
        com.bytedance.android.live.core.utils.f2.b(2131915411, 0);
        return;
    L22:
        x3 r7 = this.I;
        if (r7 == null) goto L25;
        c0.b r9 = r7.s(r5);
    L26:
        x3 r10 = this.I;
        if (r10 != null) goto L29;
    L37:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r11 = r4.j;
        if (r11 != null) goto L40;
    L48:
        if (r9 != null) goto L50;
        return;
    L50:
        if (c4.a(false) == false) goto L56;
        if (r8 == null) goto L54;
        r0 = r8.findViewById(2131384095);
    L54:
        if ((r0 instanceof RedDotView) == false) goto L56;
        ((RedDotView) r0).l();
    L56:
        r9.onClick(r8);
        b4.c.a.b(r5.f());
        X0(r5, r9);
        return;
    L40:
        if (r11.a() != true) goto L48;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r12 = r4.j;
        if (r12 == null) goto L45;
        r2 = r12.b;
    L45:
        if (TextUtils.isEmpty(r2) == true) goto L59;
        com.bytedance.android.live.core.utils.f2.c(r2, 0);
        return;
    L59:
        return;
    L29:
        if (r10.x(r5) != true) goto L37;
        x3 r13 = this.I;
        if (r13 == null) goto L34;
        r1 = r13.u(r5);
    L34:
        if (TextUtils.isEmpty(r1) == true) goto L58;
        com.bytedance.android.live.core.utils.f2.c(r1, 0);
        return;
    L58:
        return;
    L25:
        r9 = null;
        goto L26
    L12:
        r5 = null;
        goto L13
    L5:
        r3 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        h1();
        this.D = new ToolbarDisableController(getContext());
        this.I = b1();
        this.K = new MorePanelButtonDiffUpdater(this.G, this.H, this);
        jp1.c r5 = a1();
        if (r5 == null) goto L6;
        hp1.c.a.C0389a r0 = hp1.c.a.e;
        DataCenter r1 = this.F;
        Function1<hp1.c.a, Unit> r2 = new AbsAudienceToolbarButtonMoreDialog$createComposeSession$1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "b");
        hp1.c.a r3 = new hp1.c.a(r1);
        r2.invoke(r3);
        Intrinsics.checkNotNullParameter(r3, "$this$build");
        r5.c(new hp1.c(r3));
        return;
    }

    public final void setDataCenter(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.F = r3;
        if (r3 == null) goto L6;
        Room r4 = (Room) r3.get("data_room", null);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d2
    public final void setEnterFrom(String r1) {
        this.O = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d2
    public final void l0(List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r11, boolean r12) {
        if (r11 == null) goto L75;
        List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r0 = r11;
        if ((!r0.isEmpty()) != true) goto L78;
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r1 = this.C;
        if (r1.size() == r11.size()) goto L9;
    L8:
        boolean r13 = false;
    L16:
        if (r13 == false) goto L19;
        ALogger.i("AbsAudienceToolbarButtonMoreDialog", "all button same");
        return;
    L19:
        this.C.clear();
        this.C.addAll(r0);
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r14 = this.C;
        jp1.c r2 = a1();
        if (r2 == null) goto L64;
        jp1.d<Object> r3 = r2.d();
        if (r3 == null) goto L64;
        List<com.bytedance.android.livesdk.chatroom.e> r4 = r3.b(r14);
        if (r4 == null) goto L64;
        List r5 = CollectionsKt.filterIsInstance(r4, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e.class);
        if (r5 == null) goto L64;
        List r6 = r5;
        if ((!r6.isEmpty()) == false) goto L30;
        this.C.clear();
        this.C.addAll(r6);
    L30:
        String r7 = this.B;
        StringBuilder r8 = new StringBuilder("面板初始按钮:");
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r10 = r14.iterator();
    L32:
        if (r10.hasNext() == false) goto L34;
        r9.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r10.next()).f);
        goto L32
    L34:
        Object[] r15 = r9.toArray(new String[0]);
        if (r15 == null) goto L63;
        r8.append(Arrays.toString(r15));
        r8.append("\n面板UI按钮：");
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r16 = this.C;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L38:
        if (r18.hasNext() == false) goto L40;
        r17.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r18.next()).f);
        goto L38
    L40:
        Object[] r19 = r17.toArray(new String[0]);
        if (r19 == null) goto L61;
        r8.append(Arrays.toString(r19));
        ALogger.i(r7, r8.toString());
        List r20 = CollectionsKt.minus(r14, r5);
        if ((!r20.isEmpty()) == true) goto L46;
        r20 = null;
    L46:
        if (r20 == null) goto L64;
        JSONArray r21 = new JSONArray();
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r110 = r14.iterator();
    L49:
        if (r110.hasNext() == false) goto L51;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r22 = r110.next();
        JSONObject r23 = new JSONObject();
        r23.put("id", r22.g);
        r23.put(LiveEndPageData.TAG_TITLE, r22.f);
        r21.put(r23);
        goto L49
    L51:
        Single.create(new c(this, r21)).subscribeOn(Schedulers.io()).subscribe();
        List r24 = r20;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r25 = r24.iterator();
    L53:
        if (r25.hasNext() == false) goto L55;
        r111.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r25.next()).f);
        goto L53
    L55:
        Object[] r112 = r111.toArray(new String[0]);
        if (r112 == null) goto L59;
        ALogger.i(this.B, "diff buttons:" + Arrays.toString((String[]) r112));
        goto L64
    L59:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L61:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L64:
        if (r12 == true) goto L66;
        return;
    L66:
        if (isShowing() == false) goto L77;
        f1();
        return;
    L77:
        return;
    L9:
        int r26 = r1.size();
        int r27 = 0;
    L10:
        if (r27 >= r26) goto L15;
        if ((!Intrinsics.areEqual((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) ListProtector.get(r1, r27), (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) ListProtector.get(r11, r27))) == true) goto L8;
        r27 = r27 + 1;
        goto L10
    L15:
        r13 = true;
        goto L16
    L78:
        return;
    }

    public AbsAudienceToolbarButtonMoreDialog(final Context r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, false, r10, 4);
        this.B = "AbsAudienceToolbarButtonMoreDialog";
        this.C = new ArrayList();
        this.E = new TreeSet();
        this.G = new ArrayList();
        this.J = new CompositeDisposable();
        this.M = LazyKt.lazy(new AbsAudienceToolbarButtonMoreDialog$panelComposer$2(this, r8));
        this.N = new a(this);
        this.P = 0.64f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void o(WeakReference r10, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r11, View r12, int r13) {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r14 = r11;
        Intrinsics.checkNotNullParameter(r14, "button");
        Intrinsics.checkNotNullParameter(r12, "itemView");
        s<Object> r15 = r14.k;
        if (r15 == null) goto L5;
        r15.o(new WeakReference(this), r14, r12, r13);
        return;
    L5:
        View r16 = r12.findViewById(2131374718);
        TextView r0 = (TextView) r12.findViewById(2131380593);
        View r1 = r12.findViewById(2131384095);
        View r2 = r12.findViewById(2131362039);
        TextView r3 = (TextView) r12.findViewById(2131374747);
        if (r16 == null) goto L8;
        r16.setBackgroundResource(r14.b);
    L8:
        if (r0 == null) goto L10;
        r0.setText(r14.f);
    L10:
        if (r0 == null) goto L13;
        r0.setAccessibilityDelegate(com.bytedance.android.live.core.utils.t.a);
    L13:
        if (com.bytedance.android.livesdk.config.setting.o.b() == true) goto L15;
    L18:
        int r6 = 0;
        if (r14.a == false) goto L30;
        List<String> r4 = r14.c;
        if (r4 == null) goto L30;
        if ((!r4.isEmpty()) != true) goto L30;
        CompositeDisposable r5 = this.J;
        List<String> r7 = r14.c;
        if (r7 == null) goto L28;
        String r8 = (String) ListProtector.get(r7, 0);
        if (r8 == null) goto L28;
    L29:
        r5.add(com.bytedance.android.livesdk.utils.g3.a(r8).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a(this)).onErrorComplete().subscribe(new b(this, r16)));
    L28:
        r8 = "";
    L30:
        if (r3 != null) goto L32;
    L34:
        if (r3 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r3);
    L37:
        if (r14.d == false) goto L46;
        ImageView r9 = new ImageView(r16.getContext());
        if (r14.e == false) goto L41;
        int r17 = 2131251591;
    L42:
        r9.setBackgroundResource(r17);
        LiveViewStub r18 = (LiveViewStub) r12.findViewById(2131374798);
        if (r18 == null) goto L46;
        r18.a(r9);
        goto L46
    L41:
        r17 = 2131251590;
    L46:
        if (r2 == null) goto L48;
        r2.setAlpha(1.0f);
    L48:
        x3 r19 = this.I;
        if (r19 != null) goto L51;
    L52:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r20 = r14.j;
        if (r20 != null) goto L55;
    L63:
        if (r16 == null) goto L65;
        r16.setAlpha(1.0f);
    L65:
        if (r0 == null) goto L67;
        r0.setAlpha(1.0f);
    L67:
        if (r1 == 0) goto L69;
        r1.setAlpha(1.0f);
    L69:
        boolean r21 = false;
    L71:
        if (c4.a(false) == true) goto L73;
    L77:
        if (r16 == null) goto L108;
        ExtendedToolbarButton r110 = r14.m;
        if (r1 == 0) goto L108;
        if (TextUtils.isEmpty(r110.f()) == true) goto L108;
        if (c4.a(false) == true) goto L86;
        boolean r22 = b4.c.a.d(r110, this.I);
    L91:
        if (r22 == false) goto L93;
        int r23 = 0;
    L94:
        r1.setVisibility(r23);
        if ((r110 instanceof ExtendedToolbarButton.c) == true) goto L97;
    L103:
        DataCenter r111 = this.F;
        if (r111 == null) goto L108;
        if (com.bytedance.android.live.core.utils.z.h(r111) != true) goto L108;
        r1.setVisibility(8);
        goto L108
    L97:
        if (((ExtendedToolbarButton.c) r110).r == true) goto L99;
    L101:
        r6 = 8;
    L102:
        r1.setVisibility(r6);
        goto L103
    L99:
        if (h3.a(r110.f()) == true) goto L101;
    L93:
        r23 = 8;
        goto L94
    L86:
        if ((r1 instanceof RedDotView) == false) goto L88;
        r22 = ((RedDotView) r1).j();
        goto L91
    L88:
        r22 = false;
    L108:
        r12.setTag(r14);
        x3 r112 = this.I;
        if (r112 == null) goto L113;
        Map<ExtendedToolbarButton, View> r113 = r112.c;
        if (r113 == null) goto L113;
        View r114 = (View) ((HashMap) r113).put(r14.m, r12);
    L113:
        x3 r115 = this.I;
        if (r115 == null) goto L116;
        r115.D(r14.m, r12);
    L116:
        r12.setOnClickListener(this);
        DataCenter r116 = this.F;
        Long r117 = null;
        if (r116 == null) goto L119;
        Long r118 = (Long) r116.get("data_anchor_current_game_id", -1L);
    L120:
        ExtendedToolbarButton r24 = r14.m;
        if ((r24 instanceof ExtendedToolbarButton.c) == true) goto L123;
        r24 = null;
    L123:
        ExtendedToolbarButton.c r25 = (ExtendedToolbarButton.c) r24;
        if (r25 == null) goto L126;
        r117 = Long.valueOf(r25.m);
    L126:
        boolean r119 = Intrinsics.areEqual(r118, r117);
        int r120 = z3.a;
        z3.b(this.F, r14, r119, r21, r13);
        return;
    L119:
        r118 = null;
        goto L120
    L73:
        if ((r1 instanceof RedDotView) == false) goto L77;
        RedDotDelegate r26 = r14.m.c;
        if (r26 == null) goto L77;
        ((RedDotView) r1).n(r26, Boolean.FALSE);
        goto L77
    L55:
        if (r20.a() != true) goto L63;
    L56:
        if (r16 == null) goto L58;
        r16.setAlpha(this.P);
    L58:
        if (r0 == null) goto L60;
        r0.setAlpha(this.P);
    L60:
        if (r1 == 0) goto L62;
        r1.setAlpha(0.0f);
    L62:
        r21 = true;
        goto L71
    L51:
        if (r19.x(r14.m) == true) goto L56;
    L32:
        if (TextUtils.isEmpty(r14.h) == true) goto L34;
        UtilityKotlinExtentionsKt.w(r3);
        r3.setText(r14.h);
        goto L37
    L15:
        if (com.bytedance.android.live.core.utils.s1.y() >= com.bytedance.android.live.core.utils.s1.f(360.0f)) goto L18;
        if (r0 == null) goto L18;
        r0.setTextSize(1, 10.0f);
        goto L18
    }
}
