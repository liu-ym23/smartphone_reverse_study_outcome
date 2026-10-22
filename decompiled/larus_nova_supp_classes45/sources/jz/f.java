package jz;

import android.graphics.RectF;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public User a;
    public int b;
    public String c;
    public int d;
    public RectF e;
    public Room f;
    public boolean g;
    public long h;
    public long i;
    public Map<String, String> j;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "LivePublishModel(anchor=" + this.a + ", type=" + this.b + ", videoPath='" + this.c + "', minDuration=1000, maxDuration=" + this.d + ", userInfoRectF=" + this.e + ", room=" + this.f + ", isAnchor=" + this.g + ", startTime=" + this.h + ", endTime=" + this.i + ')';
    }

    public f() {
        this.c = "";
        this.d = 90000;
        this.e = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.j = MapsKt.mapOf(new Pair[]{TuplesKt.to("anchor_id", ""), TuplesKt.to("draft_item_id", ""), TuplesKt.to("draft_from_source", ""), TuplesKt.to("is_ecom", ""), TuplesKt.to("room_id", ""), TuplesKt.to("enter_from", ""), TuplesKt.to("shoot_way", ""), TuplesKt.to("content_type", ""), TuplesKt.to("content_source", "")});
    }

    public final int getType() {
        return this.b;
    }
}
