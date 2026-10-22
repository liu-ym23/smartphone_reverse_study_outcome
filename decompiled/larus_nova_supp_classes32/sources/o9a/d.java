package o9a;

import android.os.Bundle;
import android.widget.RemoteViews;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.assistant_card.provider_core.bean.CardAction;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static final /* synthetic */ int i = 0;
    public final RemoteViews a;
    public final List<CardAction> b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final long f;
    public final int g;
    public final int h;

    public static final class a {

        /* JADX INFO: renamed from: o9a.d$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/obric/aiagent/assistant_card/provider_core/bean/RemoteCard$Companion$fromBundle$remoteActions$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/obric/aiagent/assistant_card/provider_core/bean/CardAction;", "Lkotlin/collections/ArrayList;", "assistant-card-provider-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0105a extends TypeToken<ArrayList<CardAction>> {
            public C0105a() {
            }
        }

        public static d a(Bundle r11) {
            if (r11 != null) goto L5;
            p9a.b.b("RemoteCard", "fromBundle: bundle is null");
            return null;
        L5:
            RemoteViews r2 = (RemoteViews) r11.getParcelable("remote_views");
            List r3 = (List) GsonProtectorUtils.fromJson(p9a.d.a, r11.getString("remote_actions"), new C0105a().getType());
            boolean r4 = r11.getBoolean("is_night_mode");
            boolean r5 = r11.getBoolean("concern_night_Mode");
            String r0 = r11.getString("app_version_name");
            if (r0 != null) goto L9;
            r0 = NameKeys.UnloadStrategy_No_Strategy;
        L9:
            return new d(r2, r3, r4, r5, r0, r11.getLong("app_version_code"), r11.getInt("round_angle"), r11.getInt("scroll_view"));
        }
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        RemoteViews r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<CardAction> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        int r6 = 1231;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r5 + r7) * 31;
        if (this.d == true) goto L18;
        r6 = 1237;
    L18:
        int r9 = (((r8 + r6) * 31) + this.e.hashCode()) * 31;
        long r10 = this.f;
        return ((((r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.g) * 31) + this.h;
    L13:
        r7 = 1237;
        goto L14
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "RemoteCard(view=" + this.a + ", actions=" + this.b + ", isNightMode=" + this.c + ", concernNightMode=" + this.d + ", appVersionName=" + this.e + ", appVersionCode=" + this.f + ", roundAngle=" + this.g + ", scrollViewId=" + this.h + ')';
    }

    public d(RemoteViews r2, List<CardAction> r3, boolean r4, boolean r5, String r6, long r7, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r6, "appVersionName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
    }
}
