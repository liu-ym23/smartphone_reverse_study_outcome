package pt1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final Property<String> b = null;
    public static final Gson c = null;
    public static final Type d = null;
    public static final b e = null;
    public final Room a;

    /* JADX INFO: renamed from: pt1.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"pt1/a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0412a extends TypeToken<ArrayList<Long>> {
        public C0412a() {
        }
    }

    public static final class b {
        public b() {
        }

        public static ArrayList a() {
            return (ArrayList) GsonProtectorUtils.fromJson(a.c, (String) a.b.getValue(), a.d);
        L4:
            e = move-exception;
            ALogger.e("ShareFansHelper", "sp get sharedRoomId error: " + e.getMessage());
            return null;
        }
    }

    static {
        e = new b();
        b = new Property("shared_long_press_panel", "shared_room_id", "");
        c = new Gson();
        d = new C0412a().getType();
    }

    public a(Room r1) {
        this.a = r1;
    }
}
