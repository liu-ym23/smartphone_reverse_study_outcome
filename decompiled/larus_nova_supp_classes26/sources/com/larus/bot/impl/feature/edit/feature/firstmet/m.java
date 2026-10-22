package com.larus.bot.impl.feature.edit.feature.firstmet;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface m {

    public static final class a implements m {
        public final String a;
        public final SpeakerVoice b;

        public a(String r2, SpeakerVoice r3) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            Intrinsics.checkNotNullParameter(r3, "speakerVoice");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements m {
        public final String a;
        public final boolean b;

        public /* synthetic */ b() {
            throw null;
        }

        public b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "prologue");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements m {
        public final int a;

        public c() {
            this.a = 2131901103;
        }
    }

    public static final class d implements m {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e implements m {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }
}
