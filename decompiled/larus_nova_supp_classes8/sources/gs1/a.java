package gs1;

import com.bytedance.android.livesdk.clearscreen.h;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenManagerAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.IClearScreenManagerFactory;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: gs1.a$a, reason: collision with other inner class name */
    public static final class C0387a implements IClearScreenManagerFactory {
        public C0387a() {
        }

        public final jg1.b create(String r2) {
            return new h(r2);
        }
    }

    public static final class b implements IClearScreenManagerFactory {
        public b() {
        }

        public final jg1.b create(String r2) {
            return new h("ClearScreenManagerAbility_SSS_111");
        }
    }

    public static h b() {
        ClearScreenManagerAbility r0 = ClearScreenManagerAbility.INSTANCE;
        r0.setFactory(new b());
        jg1.b r1 = r0.getInstance("ClearScreenManagerAbility_SSS_111");
        if ((r1 instanceof h) == true) goto L6;
        r1 = null;
    L6:
        return (h) r1;
    }

    static {
    }

    public static h a(String r2) {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L5;
        ClearScreenManagerAbility r0 = ClearScreenManagerAbility.INSTANCE;
        r0.setFactory(new C0387a());
        jg1.b r3 = r0.getInstance(r2);
        if ((r3 instanceof h) == true) goto L10;
        r3 = null;
    L10:
        return (h) r3;
    L5:
        return b();
    }
}
