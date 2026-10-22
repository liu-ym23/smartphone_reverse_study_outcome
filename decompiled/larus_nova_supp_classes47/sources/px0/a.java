package px0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: px0.a$a, reason: collision with other inner class name */
    public static final class C0293a {
    }

    public static final class b extends a {
        public final IEpisode b;

        @Override // px0.a
        public final boolean c() {
            return true;
        }

        @Override // px0.a
        public final String a() {
            IBaseUser r0 = this.b.getOwnerExt();
            if (r0 == null) goto L5;
            String r1 = r0.getIdString();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // px0.a
        public final long b() {
            return this.b.getRoomIdExt();
        }

        public b(IEpisode r2) {
            Intrinsics.checkNotNullParameter(r2, "episode");
            this.b = r2;
        }
    }

    public static final class c extends a {
        public final IRoom b;

        @Override // px0.a
        public final String a() {
            IBaseUser r0 = this.b.getOwner();
            if (r0 == null) goto L5;
            String r1 = r0.getIdString();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // px0.a
        public final long b() {
            return this.b.getRoomId();
        }

        @Override // px0.a
        public final boolean c() {
            return this.b.isVsRoom();
        }

        public c(IRoom r2) {
            Intrinsics.checkNotNullParameter(r2, "room");
            this.b = r2;
        }
    }

    static {
    }

    public a() {
    }

    public abstract String a();

    public abstract long b();

    public abstract boolean c();
}
