package com.larus.bot.impl.feature.edit.feature.avatar;

import androidx.activity.result.ActivityResult;
import com.larus.bot.impl.bean.BotAvatarIconData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.avatar.a$a, reason: collision with other inner class name */
    public static final class C0055a implements a {
        public static final C0055a a = null;

        static {
            a = new C0055a();
        }

        public C0055a() {
        }
    }

    public static final class b implements a {
        public final ActivityResult a;

        public b(ActivityResult r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.a = r2;
        }
    }

    public static final class c implements a {
        public final BotAvatarIconData a;

        public c(BotAvatarIconData r1) {
            this.a = r1;
        }
    }

    public static final class d implements a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e implements a {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f implements a {
        public f(boolean r1) {
        }
    }
}
