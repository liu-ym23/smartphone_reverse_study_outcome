package cb8;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 implements kc8.b0 {
    public final /* synthetic */ com.larus.bmhome.chat.api.q0.a a;
    public final /* synthetic */ t1 b;

    @Override // kc8.b0
    public final Set<String> a() {
        com.larus.bmhome.chat.component.trace.z r0 = this.a.E9();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.RY();
    }

    @Override // kc8.b0
    public final void d() {
        t1 r0 = this.b;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        Fragment r2 = r0.c;     // Catch: Throwable -> L27
        Unit r3 = null;
        if (r2 == null) goto L11;
        FragmentActivity r4 = r2.getActivity();     // Catch: Throwable -> L27
        if (r4 == null) goto L11;
        FragmentManager r5 = r4.getSupportFragmentManager();     // Catch: Throwable -> L27
        if (r5 == null) goto L11;
        Fragment r6 = r5.findFragmentByTag("ChatCreationPagerFragment");     // Catch: Throwable -> L27
        if (r6 == null) goto L11;
    L19:
        if (r6 == null) goto L25;
        FragmentActivity r7 = r6.getActivity();     // Catch: Throwable -> L27
        if (r7 == null) goto L25;
        FragmentManager r8 = r7.getSupportFragmentManager();     // Catch: Throwable -> L27
        if (r8 == null) goto L25;
        FragmentTransaction r9 = r8.beginTransaction();     // Catch: Throwable -> L27
        r9.remove(r6);     // Catch: Throwable -> L27
        r9.commitAllowingStateLoss();     // Catch: Throwable -> L27
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Object r10 = Result.constructor-impl(r3);     // Catch: Throwable -> L27
    L29:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L36;
        FLogger.a.w("BlockComponent", "dismissCreationPage", r11);
        return;
    L36:
        return;
    L11:
        Fragment r12 = r0.c;     // Catch: Throwable -> L27
        if (r12 == null) goto L18;
        FragmentActivity r13 = r12.getActivity();     // Catch: Throwable -> L27
        if (r13 == null) goto L18;
        FragmentManager r14 = r13.getSupportFragmentManager();     // Catch: Throwable -> L27
        if (r14 == null) goto L18;
        r6 = r14.findFragmentByTag("ChatGalleryDialog");     // Catch: Throwable -> L27
    L18:
        r6 = null;
    L27:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    @Override // kc8.b0
    public final void E0(ICoreInputAbility.OnSendParams r2) {
        Intrinsics.checkNotNullParameter(r2, "onSendParams");
        ICoreInputAbility r0 = this.a.v0();
        if (r0 == null) goto L6;
        r0.E0(r2);
        return;
    }

    @Override // kc8.b0
    public final void c(DialogFragment r4) {
        t1 r0 = this.b;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        Fragment r2 = r0.c;     // Catch: Throwable -> L17
        if (r2 == null) goto L14;
        FragmentManager r3 = r2.getParentFragmentManager();     // Catch: Throwable -> L17
        if (r3 == null) goto L14;
        if (r4 == null) goto L14;
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L17
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "TemplateDialogFragment", r5);     // Catch: Throwable -> L17
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r4, r5) == false) goto L27;
    L13:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L17
    L19:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L29;
        FLogger.a.w("BlockComponent", "showDialogFragment", r8);
        return;
    L29:
        return;
    L27:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24 Throwable -> L17
    L12:
        r4.show(r3, "TemplateDialogFragment");     // Catch: Throwable -> L17
    L14:
        r6 = null;
    L17:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public r1(com.larus.bmhome.chat.api.q0.a r1, t1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // kc8.b0
    public final void F5(nr9.g r2, String r3, Map<String, String> r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "videoPlayData");
        Intrinsics.checkNotNullParameter(r3, ChatDraftItem.TYPE_TEXT);
        ICoreInputAbility r0 = this.a.v0();
        if (r0 == null) goto L6;
        r0.F5(r2, r3, r4, r5);
        return;
    }

    @Override // kc8.b0
    public final void b(Serializable r22, String r23, String r24, zs8.a r25) {
        Intrinsics.checkNotNullParameter(r22, "imageEditDataWithMask");
        Intrinsics.checkNotNullParameter(r23, "prompt");
        t1 r3 = this.b;
        Fragment r5 = r3.c;
        if (r5 == null) goto L40;
        com.larus.bmhome.chat.api.q0.a r4 = this.a;
        IUgcAIGCService.Companion r15 = IUgcAIGCService.a;
        com.larus.bmhome.chat.api.q0 r7 = r3.e;
        ImageEditDataWithMask r19 = null;
        if (r7 == null) goto L9;
        ChatParam r8 = r7.getChatParam();
        if (r8 == null) goto L9;
        String r9 = r8.a;
    L10:
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        if ((r25 instanceof ny9.u) == false) goto L15;
        ny9.u r10 = (ny9.u) r25;
    L16:
        com.larus.bmhome.chat.api.q0 r2 = r3.e;
        if (r2 == null) goto L21;
        ChatParam r6 = r2.getChatParam();
        if (r6 == null) goto L21;
        String r12 = r6.b;
    L22:
        com.larus.bmhome.chat.api.q0 r11 = r3.e;
        if (r11 == null) goto L27;
        com.larus.bmhome.chat.api.q0.a r13 = r11.getProvider();
        if (r13 == null) goto L27;
        u7 r14 = r13.u3();
    L28:
        Fragment r16 = r3.c;
        if (r16 == null) goto L31;
        IChatDoubleTabAbility r17 = (IChatDoubleTabAbility) s1a.a.g(r16).getAbility(IChatDoubleTabAbility.class);
    L32:
        hy9.f r18 = new hy9.f(r5, null, r9, r23, r24, r10, null, r12, r14, r17, r4.v0(), null, null, 61440);
        if ((r22 instanceof ImageEditDataWithMask) == false) goto L35;
        r19 = (ImageEditDataWithMask) r22;
    L35:
        ImageEditDataWithMask r1 = r19;
        if (r1 == null) goto L41;
        r15.x(r18, r1);
        return;
    L41:
        return;
    L31:
        r17 = null;
    L27:
        r14 = null;
    L21:
        r12 = null;
        goto L22
    L15:
        r10 = null;
    L9:
        r9 = null;
        goto L10
    }
}
