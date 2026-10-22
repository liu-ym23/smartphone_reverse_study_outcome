package c21;

import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final a a;
    public final f b;
    public final String c;

    public static final class a {
        public final long a;
        public final int b;
        public final PlayMode c;
        public final BattleInviteType d;
        public final String e;
        public final String f;
        public final List<String> g;
        public final int h;
        public final IBattleConfigSetting i;

        public a() {
            throw null;
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L24;
            a r7 = (a) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
            return false;
        L20:
            if (this.h == r7.h) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.i, r7.i) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
            PlayMode r2 = this.c;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            BattleInviteType r6 = this.d;
            if (r6 == null) goto L9;
            int r7 = r6.hashCode();
        L10:
            int r8 = (r5 + r7) * 31;
            String r9 = this.e;
            if (r9 == null) goto L13;
            int r10 = r9.hashCode();
        L14:
            int r12 = (r8 + r10) * 31;
            String r13 = this.f;
            if (r13 == null) goto L17;
            int r14 = r13.hashCode();
        L18:
            int r15 = (r12 + r14) * 31;
            List<String> r16 = this.g;
            if (r16 == null) goto L21;
            int r17 = r16.hashCode();
        L22:
            int r18 = (((r15 + r17) * 31) + this.h) * 31;
            IBattleConfigSetting r19 = this.i;
            if (r19 == null) goto L26;
            r3 = r19.hashCode();
        L26:
            return r18 + r3;
        L21:
            r17 = 0;
            goto L22
        L17:
            r14 = 0;
            goto L18
        L13:
            r10 = 0;
            goto L14
        L9:
            r7 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "CommonParams(duration=" + this.a + ", scene=" + this.b + ", playMode=" + this.c + ", inviteType=" + this.d + ", theme=" + this.e + ", token=" + this.f + ", selectAnchorIds=" + this.g + ", anchorListSize=" + this.h + ", battleConfigSetting=" + this.i + ")";
        }

        public a(long r4, int r6, PlayMode r7, BattleInviteType r8, String r9, String r10, List r12, IBattleConfigSetting r13, int r14) {
            if ((r14 & 2) == 0) goto L6;
            r6 = 1;
        L6:
            if ((r14 & 4) == 0) goto L9;
            r7 = null;
        L9:
            if ((r14 & 8) == 0) goto L12;
            r8 = BattleInviteType.UNKNOWN;
        L12:
            if ((r14 & 16) == 0) goto L15;
            r9 = "";
        L15:
            if ((r14 & 32) == 0) goto L18;
            r10 = "";
        L18:
            if ((r14 & 64) == 0) goto L21;
            r12 = null;
        L21:
            if ((r14 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L23;
            r13 = null;
        L23:
            Intrinsics.checkNotNullParameter(r8, "inviteType");
            Intrinsics.checkNotNullParameter(r9, FileUtils.PICTURE_THEME);
            Intrinsics.checkNotNullParameter(r10, Constants.OperatorKey.KEY_TOKEN);
            this.a = r4;
            this.b = r6;
            this.c = r7;
            this.d = r8;
            this.e = r9;
            this.f = r10;
            this.g = r12;
            this.h = 0;
            this.i = r13;
        }
    }

    public e(a r2, f r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commonParams");
        Intrinsics.checkNotNullParameter(r3, "battlePlayMode");
        Intrinsics.checkNotNullParameter(r4, "name");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
