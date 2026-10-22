package com.ss.android.lark.chat.api.service.track.sample.handler;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.larkconfig.export.plugin.AppSettingPlugin;
import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReactionSampleSettingHandler extends AbstractBaseSettingHandler.b {
    public static final ReactionSampleSettingHandler i = null;

    @AppSettingPlugin
    public static final class a implements npb.a {
        public a() {
        }

        public final void a() {
        }

        public final Collection<AbstractBaseSettingHandler> b() {
            return SetsKt.mutableSetOf(new ReactionSampleSettingHandler[]{ReactionSampleSettingHandler.i});
        }

        public final String getTag() {
            return "ReactionSampleSettingHandler";
        }
    }

    public final String a() {
        return "reaction_sample_report";
    }

    public final String f() {
        return "ReactionSampleSettingHandler";
    }

    static {
        ReactionSampleSettingHandler r0 = new ReactionSampleSettingHandler();
        i = r0;
        AbstractBaseSettingHandler.a r1 = ((AbstractBaseSettingHandler) r0).d;
        AnonymousClass1 r2 = AnonymousClass1.INSTANCE;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "strategy");
        r1.a(r1.b, r2);
        r1.b(AnonymousClass2.INSTANCE);
        r1.c(AnonymousClass3.INSTANCE);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        ((AbstractBaseSettingHandler) r0).f = r1;
    }

    public ReactionSampleSettingHandler() {
    }
}
