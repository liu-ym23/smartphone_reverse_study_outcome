package com.larus.bmhome.instruction.handler;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper;
import com.larus.im.bean.message.Image;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PromptImageToVideoHandler extends i {
    public final com.larus.bmhome.instruction.p j;
    public final AiBeautifyPickPhotoHelper k;
    public final z0 l;
    public com.larus.bmhome.instruction.n m;
    public final int n;

    public final String f() {
        com.larus.bmhome.instruction.n r0 = this.m;
        if (r0 == null) goto L8;
        aq8.e r1 = r0.b;
        if (r1 == null) goto L8;
        String r2 = r1.a;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r20) {
        Intrinsics.checkNotNullParameter(r20, "inputData");
        this.m = r20;
        aq8.e r1 = r20.b;
        if (r1 == null) goto L5;
        Image r2 = r1.j;
    L6:
        if (r2 == null) goto L12;
        if (r1 == null) goto L10;
        Image r3 = r1.j;
        if (r3 == null) goto L10;
    L11:
        g(r3);
        return;
    L10:
        r3 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        goto L11
    L12:
        FragmentActivity r4 = d().getActivity();
        if (r4 == null) goto L19;
        AiBeautifyPickPhotoHelper r5 = this.k;
        if (r5 == null) goto L20;
        com.larus.bmhome.instruction.helper.f.a.a(r5, r4, 6);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void g(Image r14) {
        FLogger r0 = FLogger.a;
        r0.i("PromptImageToVideoHandler", "toVideoGenerateByImage");
        com.larus.bmhome.chat.component.cvs.y r2 = b();
        if (r2 == null) goto L5;
        wc9.e r3 = r2.h();
    L6:
        if (r3 == null) goto L8;
        String r5 = r3.a;
    L9:
        z0 r4 = this.l;
        if (r4 == null) goto L12;
        com.larus.bmhome.actionbar.model.r r6 = r4.q;
    L13:
        boolean r7 = true;
        if (r5 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == true) goto L47;
        if (r6 == null) goto L47;
        String r1 = r14.localResPath;
        if (r1 != null) goto L26;
    L29:
        boolean r9 = true;
    L30:
        if (r9 == false) goto L39;
        String r10 = r14.key;
        if (r10 != null) goto L34;
    L37:
        if (r7 == false) goto L39;
        return;
    L34:
        if (r10.length() == 0) goto L37;
        r7 = false;
    L39:
        g1 r11 = (g1) this.i.getValue();
        if (r11 == null) goto L42;
        r11.W0();
    L42:
        ICoreInputAbility r12 = c();
        if (r12 == null) goto L45;
        r12.C1(false, false, "click_leave");
    L45:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new PromptImageToVideoHandler$toVideoGenerateByImage$1(this, r6, r14, r5, null), 2, null);
        return;
    L26:
        if (r1.length() == 0) goto L29;
        r9 = false;
    L47:
        r0.e("PromptImageToVideoHandler", "toVideoGenerateByImage conversationId:" + r5 + "actionBarItem:" + this.l);
        return;
    L16:
        if (r5.length() == 0) goto L19;
        r8 = false;
        goto L20
    L12:
        r6 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public PromptImageToVideoHandler(com.larus.bmhome.instruction.p r2, AiBeautifyPickPhotoHelper r3) {
        Intrinsics.checkNotNullParameter(r2, "instructionCoreAbility");
        super(r2);
        this.j = r2;
        this.k = r3;
        this.n = 18;
        if (r3 == null) goto L5;
        r3.b = new x(this);
    L5:
        this.l = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(18);
    }
}
