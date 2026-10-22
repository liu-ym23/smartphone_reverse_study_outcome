package com.larus.bmhome.chat.camera.command;

import android.net.Uri;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements ex8.b {
    public final f a;
    public final p b;
    public final d c;
    public SuggestedAction d;

    public static final class a {
    }

    static {
    }

    public c(f r2, p r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "stateProvider");
        Intrinsics.checkNotNullParameter(r3, "suggestedActionProvider");
        Intrinsics.checkNotNullParameter(r4, "sideEffect");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final Object a(String r8, int r9, Object r10) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        FLogger.a.i("CameraCommandHandler", "[onCommand] scene=" + r8 + ", cmd=" + r9 + ", data=" + r10);
        boolean r1 = false;
        SuggestedAction r2 = null;
        if (r9 != 1) goto L5;
    L72:
        boolean r11 = this.a.k5();
        boolean r4 = !this.b.d3();
        boolean r5 = this.a.i9();
        boolean r6 = this.a.c1();
        if (r11 == true) goto L111;
        if (r4 == true) goto L112;
        if (r5 == true) goto L113;
        if (r6 == true) goto L115;
        if (r9 == 1) goto L86;
        if (r9 == 12) goto L85;
        switch(r9) {
            case 8: goto L84;
            case 9: goto L83;
            case 10: goto L82;
            default: goto L81;
        };
    L81:
        SuggestedActionScene r12 = SuggestedActionScene.PreviewArea;
    L88:
        if ((r10 instanceof String) == false) goto L90;
        String r13 = (String) r10;
    L91:
        if (r13 != null) goto L94;
        r13 = "";
    L94:
        if (ObricChatSPIServiceDelegate.b.i() == false) goto L114;
        final CompletableDeferred r14 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.b.b(r12, r13, false, new b(r14));
        return r14;
    L114:
        return this.b.r4(r12, r13, false);
    L90:
        r13 = null;
        goto L91
    L82:
        r12 = SuggestedActionScene.PPTGenerationSingleImg;
        goto L88
    L83:
        r12 = SuggestedActionScene.HomeworkCorrectionCamera;
        goto L88
    L84:
        r12 = SuggestedActionScene.AttachmentAreaMultiImg;
        goto L88
    L85:
        r12 = SuggestedActionScene.EduSolveQuestionCamera;
        goto L88
    L86:
        r12 = SuggestedActionScene.PreviewArea;
        goto L88
    L115:
        return null;
    L113:
        return null;
    L112:
        return null;
    L111:
        return null;
    L5:
        if (r9 == 8) goto L72;
        if (r9 == 9) goto L72;
        if (r9 == 12) goto L72;
        if (r9 == 10) goto L72;
        if (r9 != 2) goto L18;
        if ((r10 instanceof Uri) == false) goto L18;
        return this.c.c(r8, (Uri) r10);
    L18:
        if (r9 != 3) goto L31;
        if (r10 != null) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == false) goto L31;
        SuggestedAction r16 = (SuggestedAction) r10;
        if (r16 == null) goto L29;
        Map r17 = r16.getEventExtra();
        if (r17 == null) goto L28;
        String r18 = (String) r17.put("sug_scene", "attachment_suggest");
    L28:
        r2 = r16;
    L29:
        this.d = r2;
        this.c.b(r2);
        return Unit.INSTANCE;
    L21:
        r15 = r10 instanceof SuggestedAction;
    L31:
        if (r9 != 4) goto L36;
        if ((r10 instanceof List) == false) goto L36;
        this.c.d(false, (List) r10);
        return Unit.INSTANCE;
    L36:
        if (r9 != 5) goto L41;
        if ((r10 instanceof List) == false) goto L41;
        this.c.d(true, (List) r10);
        return Unit.INSTANCE;
    L41:
        if (r9 != 6) goto L68;
        if (FeatureKitDelegate.b.q0().b() == true) goto L107;
        BotModel r19 = this.a.a();
        if (r19 == null) goto L64;
        List r20 = r19.getBotConf();
        if (r20 == null) goto L64;
        Iterator r21 = r20.iterator();
    L50:
        if (r21.hasNext() == false) goto L59;
        Object r22 = r21.next();
        BotConfItem r110 = (BotConfItem) r22;
        if (Intrinsics.areEqual(r110.getConfGroupKey(), "disable_function") == true) goto L54;
    L56:
        boolean r111 = false;
    L57:
        if (r111 == false) goto L50;
    L60:
        BotConfItem r23 = (BotConfItem) r22;
        if (r23 == null) goto L64;
        r2 = r23.getConfValue();
        goto L64
    L54:
        if (Intrinsics.areEqual(r110.getConfKey(), "apply_preview_skip_optional") == false) goto L56;
        r111 = true;
        goto L57
    L59:
        r22 = null;
    L64:
        if (Intrinsics.areEqual(r2, "1") == false) goto L107;
        r1 = true;
    L107:
        return Boolean.valueOf(r1);
    L68:
        if (r9 == 7) goto L70;
        return null;
    L70:
        if ((r10 instanceof Uri) == true) goto L110;
        return null;
    L110:
        return this.c.e((Uri) r10);
    }
}
