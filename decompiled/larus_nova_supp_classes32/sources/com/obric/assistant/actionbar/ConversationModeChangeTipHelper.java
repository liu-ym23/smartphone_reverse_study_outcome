package com.obric.assistant.actionbar;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.impl.databinding.ObricDialogConversationModeChangedTipBodyBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.task.skill.ObricOmniModeTag;
import com.obric.assistant.task.skill.ObricOmniModelTag;
import com.obric.assistant.task.skill.m;
import com.obric.assistant.util.r2;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ConversationModeChangeTipHelper {
    public static final CoroutineScope a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/actionbar/ConversationModeChangeTipHelper$Source;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "ACTION_BAR", "SETTING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source ACTION_BAR = null;
        public static final Source SETTING = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("ACTION_BAR", 0);
            ACTION_BAR = r0;
            Source r1 = new Source("SETTING", 1);
            SETTING = r1;
            Source[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Source.values().length];
            r0[Source.ACTION_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Source.SETTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        b = LazyKt.lazy(new com.obric.assistant.actionbar.a());
        c = LazyKt.lazy(new b());
        d = LazyKt.lazy(new c());
        e = LazyKt.lazy(new d());
        f = LazyKt.lazy(new e());
        g = LazyKt.lazy(new f());
    }

    public static String a(String r1) {
        AtomicBoolean r0 = m.a;
        if (m.m() == true) goto L5;
        return r1;
    L5:
        return "new_style_".concat(r1);
    }

    public static Set b(String r2) {
        return CollectionsKt.toMutableSet(((Keva) b.getValue()).getStringSet(r2, SetsKt.emptySet()));
    }

    public static void c(Source r17, ReplyOption r18, Activity r19) {
        Intrinsics.checkNotNullParameter(r17, "source");
        Intrinsics.checkNotNullParameter(r18, "replyOption");
        Intrinsics.checkNotNullParameter(r19, "context");
        int[] r4 = a.a;
        int r5 = r4[r17.ordinal()];
        if (r5 == 1) goto L11;
        if (r5 != 2) goto L10;
        AtomicBoolean r6 = m.a;
        if (m.m() == false) goto L8;
        Set r7 = (Set) e.getValue();
    L15:
        AtomicBoolean r8 = m.a;
        if (m.m() == false) goto L18;
        String r9 = r18.getModeId();
    L19:
        if (r9 != null) goto L21;
        return;
    L21:
        t1a.b r10 = r2.a();
        if (r10 == null) goto L26;
        y r11 = r10.o(Reflection.getOrCreateKotlinClass(y.class));
        if (r11 == null) goto L26;
        wc9.e r12 = r11.h();
    L28:
        if (r17 != Source.ACTION_BAR) goto L33;
        if (r12 == null) goto L33;
        if (com.larus.bmhome.utils.i.h(r12) == true) goto L33;
        Pair r1 = TuplesKt.to(Boolean.FALSE, AgentMode.UNKNOWN);
    L66:
        boolean r13 = ((Boolean) r1.component1()).booleanValue();
        AgentMode r2 = (AgentMode) r1.component2();
        if (r13 == true) goto L69;
        return;
    L69:
        if (r7.contains(r9) == true) goto L123;
        r7.add(r9);
        int r0 = r4[r17.ordinal()];
        if (r0 == 1) goto L76;
        if (r0 != 2) goto L75;
        String r3 = a("setting_has_shown_reply_options");
    L77:
        BuildersKt.launch$default(a, null, null, new ConversationModeChangeTipHelper$persistHasShownReplyOptions$1(r3, r7, null), 3, null);
        WeakReference<com.obric.oui.dialog.v2.alert.c> r14 = l.a;
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r2, "agentMode");
        if ((r19 instanceof Activity) == true) goto L81;
        FLogger.a.i("ObricModeSwitchHintDialog", "showIfNeeded context is not Activity");
        return;
    L81:
        if (r19.isFinishing() == false) goto L83;
    L117:
        FLogger.a.i("ObricModeSwitchHintDialog", "showIfNeeded context is destroyed");
        return;
    L83:
        if (r19.isDestroyed() == true) goto L117;
        WeakReference<com.obric.oui.dialog.v2.alert.c> r15 = l.a;
        if (r15 == null) goto L92;
        com.obric.oui.dialog.v2.alert.c r16 = r15.get();
        if (r16 == null) goto L92;
        if (r16.isShowing() != true) goto L92;
        boolean r20 = true;
    L93:
        if (r20 == false) goto L95;
        FLogger.a.i("ObricModeSwitchHintDialog", "showIfNeeded dialog is showing");
        return;
    L95:
        View r21 = LayoutInflater.from(r19).inflate(2131563981, null, false);
        int r22 = 2131374365;
        AppCompatTextView r23 = ViewBindings.findChildViewById(r21, 2131374365);
        if (r23 == null) goto L116;
        r22 = 2131374366;
        AppCompatTextView r24 = ViewBindings.findChildViewById(r21, 2131374366);
        if (r24 == null) goto L116;
        final ObricDialogConversationModeChangedTipBodyBinding r25 = new ObricDialogConversationModeChangedTipBodyBinding((FrameLayout) r21, r23, r24);
        if (r2 != AgentMode.MOA) goto L102;
        String r26 = r19.getString(2131912026);
    L103:
        r23.setText(r26);
        StringCompanionObject r27 = StringCompanionObject.INSTANCE;
        r24.setText(String.format(r19.getString(2131912024), Arrays.copyOf(new Object[]{" · ", " · ", " · "}, 3)));
        com.obric.oui.dialog.v2.alert.g r28 = new com.obric.oui.dialog.v2.alert.g(r19);
        r28.w = false;
        if (l.a.a[r2.ordinal()] != 1) goto L106;
        int r29 = 2131912027;
    L107:
        com.obric.oui.dialog.v2.alert.g.i(r28, r19.getString(r29));
        zla.g r30 = new zla.g(new i(r25));
        Intrinsics.checkNotNullParameter(r30, "controller");
        r28.x = r30;
        r28.e(r19.getString(2131911948), new j());
        DialogInterface.OnDismissListener r31 = new k();
        Intrinsics.checkNotNullParameter(r31, "onDismissListener");
        ((com.obric.oui.dialog.base.i) r28).a = r31;
        com.obric.oui.dialog.v2.alert.c r32 = r28.a();
        l.a = new WeakReference(r32);
        if (DialogLancet.shouldBlockDialogShow(r32) == false) goto L120;
        DialogLancet.handleBlockedDialogShow(r32);
    L113:
        if (r32.isShowing() == true) goto L126;
        l.a = null;
        return;
    L126:
        return;
    L120:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L119
    L111:
        DialogLancet.beforeDialogShow(r32);
        r32.show();
        DialogLancet.afterDialogShow(r32);
        goto L113
    L106:
        r29 = 2131912029;
        goto L107
    L102:
        r26 = r19.getString(2131912028);
    L116:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r22)));
    L92:
        r20 = false;
        goto L93
    L75:
        throw new NoWhenBranchMatchedException();
    L76:
        r3 = a("action_bar_has_shown_reply_options");
        goto L77
    L123:
        return;
    L33:
        Lazy r33 = g;
        IActionBarService r110 = (IActionBarService) r33.getValue();
        if (r110 == null) goto L36;
        boolean r111 = r110.m(r18);
    L37:
        if (r111 == false) goto L39;
        r1 = TuplesKt.to(Boolean.TRUE, AgentMode.MOA);
        goto L66
    L39:
        IActionBarService r34 = (IActionBarService) r33.getValue();
        if (r34 == null) goto L62;
        Integer r35 = r34.i(r18);
        if (r35 == null) goto L62;
        int r36 = r35.intValue();
        String r112 = r18.getModel().getKey();
        String r37 = r18.getModeId();
        if (r37 != null) goto L47;
        if (r112 == null) goto L62;
    L47:
        String r113 = m.f(ObricOmniModelTag.PROFESSIONAL);
        String r114 = m.e(ObricOmniModeTag.QUICK);
        String r115 = m.e(ObricOmniModeTag.PROFESSIONAL);
        if (r36 != AgentMode.CHAT.getValue()) goto L62;
        if (m.a.get() == true) goto L52;
        boolean r38 = Intrinsics.areEqual(r112, r113);
    L60:
        if (r38 == false) goto L62;
        boolean r39 = true;
    L63:
        if (r39 == false) goto L65;
        r1 = TuplesKt.to(Boolean.TRUE, AgentMode.CHAT);
        goto L66
    L65:
        r1 = TuplesKt.to(Boolean.FALSE, AgentMode.UNKNOWN);
        goto L66
    L52:
        if (Intrinsics.areEqual(r37, r114) == false) goto L56;
        if (Intrinsics.areEqual(r112, r113) == false) goto L56;
    L57:
        r38 = true;
    L56:
        if (Intrinsics.areEqual(r37, r115) == true) goto L57;
        r38 = false;
    L62:
        r39 = false;
        goto L63
    L36:
        r111 = false;
    L26:
        r12 = null;
        goto L28
    L18:
        r9 = r18.getModel().getKey();
        goto L19
    L8:
        r7 = (Set) f.getValue();
        goto L15
    L10:
        throw new NoWhenBranchMatchedException();
    L11:
        AtomicBoolean r40 = m.a;
        if (m.m() == false) goto L14;
        r7 = (Set) c.getValue();
        goto L15
    L14:
        r7 = (Set) d.getValue();
        goto L15
    }
}
