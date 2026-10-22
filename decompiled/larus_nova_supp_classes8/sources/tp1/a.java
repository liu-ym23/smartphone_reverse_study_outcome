package tp1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IDefinitionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSWatermark;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSWatermarkIcon;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.model.VideoRef;
import fq1.t;
import java.util.ArrayList;
import java.util.List;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;
    public String h;
    public List<IDefinitionInfo> i;
    public VideoRef j;
    public String k;
    public long l;
    public int m;
    public b n;
    public final VSWatermark o;
    public int p;
    public String q;
    public Episode r;

    public static VSWatermarkIcon a() {
        VSWatermarkIcon r0 = new VSWatermarkIcon();
        k r1 = f.c(k.class);
        ArrayList r2 = new ArrayList();
        r2.add("");
        r1.setUrls(r2);
        r0.icon = r1;
        r0.iconWidth = 0L;
        r0.landscapeMargin = 0L;
        r0.portraitMargin = 0L;
        return r0;
    }

    public final VSWatermarkIcon d() {
        VSWatermark r0 = this.o;
        if (r0.vsWatermarkIcon != null) goto L6;
        r0.vsWatermarkIcon = new ArrayList();
        this.o.vsWatermarkIcon.add(a());
        this.o.vsWatermarkIcon.add(a());
    L6:
        return (VSWatermarkIcon) ListProtector.get(this.o.vsWatermarkIcon, 0);
    }

    public final VSWatermarkIcon f() {
        VSWatermark r0 = this.o;
        if (r0.vsWatermarkIcon != null) goto L6;
        r0.vsWatermarkIcon = new ArrayList();
        this.o.vsWatermarkIcon.add(a());
        this.o.vsWatermarkIcon.add(a());
    L6:
        return (VSWatermarkIcon) ListProtector.get(this.o.vsWatermarkIcon, 1);
    }

    public long insert() {
        ContentValues r0 = new ContentValues();
        r0.put("video_id", this.a);
        r0.put(LiveEndPageData.TAG_TITLE, this.c);
        r0.put("download_size", Long.valueOf(this.n.a));
        r0.put("total_size", Long.valueOf(this.n.b));
        r0.put("time", Long.valueOf(this.n.e));
        r0.put("state", Integer.valueOf(this.n.c));
        r0.put("error_code", Integer.valueOf(this.n.d));
        r0.put("season_name", this.d);
        r0.put("season_id", this.e);
        r0.put("cover_url", this.f);
        r0.put("definition", this.h);
        r0.put("episode_id", Long.valueOf(this.l));
        r0.put("video_key", this.n.f);
        r0.put("video_duration", Long.valueOf(this.g));
        r0.put("current_period", this.b);
        r0.put("item_id", this.k);
        r0.put("style", Integer.valueOf(this.m));
        r0.put("position", this.o.position);
        r0.put("vertical_url", (String) ListProtector.get(e(), 0));
        r0.put("vertical_width", f().iconWidth);
        r0.put("vertical_margin_l", f().landscapeMargin);
        r0.put("vertical_margin_p", f().portraitMargin);
        r0.put("horizontal_url", (String) ListProtector.get(c(), 0));
        r0.put("horizontal_width", d().iconWidth);
        r0.put("horizontal_margin_l", d().landscapeMargin);
        r0.put("horizontal_margin_p", d().portraitMargin);
        r0.put("episode_stage_type", Integer.valueOf(this.p));
        r0.put("download_uid", this.q);
        return c.insert(r0);
    }

    public final String toString() {
        StringBuilder r3 = new StringBuilder("TaskInfo{mVideoId='");     // Catch: Throwable -> L11
        String r2 = this.a;     // Catch: Throwable -> L11
        if (r2 != null) goto L6;
        r2 = "0";
    L6:
        r3.append(r2);     // Catch: Throwable -> L11
        r3.append("', mTitle='");     // Catch: Throwable -> L11
        String r1 = this.c;     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r3.append(r1);     // Catch: Throwable -> L11
        r3.append("'}");     // Catch: Throwable -> L11
        return r3.toString();
    L12:
        return super.toString();
    }

    public void update() {
        ContentValues r0 = new ContentValues();
        r0.put(LiveEndPageData.TAG_TITLE, this.c);
        r0.put("download_size", Long.valueOf(this.n.a));
        r0.put("total_size", Long.valueOf(this.n.b));
        r0.put("time", Long.valueOf(this.n.e));
        r0.put("state", Integer.valueOf(this.n.c));
        r0.put("error_code", Integer.valueOf(this.n.d));
        r0.put("season_name", this.d);
        r0.put("season_id", this.e);
        r0.put("cover_url", this.f);
        r0.put("definition", this.h);
        r0.put("episode_id", Long.valueOf(this.l));
        r0.put("video_key", this.n.f);
        r0.put("video_duration", Long.valueOf(this.g));
        r0.put("current_period", this.b);
        r0.put("item_id", this.k);
        r0.put("style", Integer.valueOf(this.m));
        r0.put("position", this.o.position);
        r0.put("vertical_url", (String) ListProtector.get(e(), 0));
        r0.put("vertical_width", f().iconWidth);
        r0.put("vertical_margin_l", f().landscapeMargin);
        r0.put("vertical_margin_p", f().portraitMargin);
        r0.put("horizontal_url", (String) ListProtector.get(c(), 0));
        r0.put("horizontal_width", d().iconWidth);
        r0.put("horizontal_margin_l", d().landscapeMargin);
        r0.put("horizontal_margin_p", d().portraitMargin);
        r0.put("episode_stage_type", Integer.valueOf(this.p));
        r0.put("download_uid", this.q);
        if (StringUtils.isEmpty(this.q) == false) goto L5;
        c.update(r0, "video_id=? AND download_uid IS NULL", new String[]{this.a});
        return;
    L5:
        c.update(r0, "video_id=? AND download_uid=?", new String[]{this.a, this.q});
    }

    public a() {
        this.a = "0";
        this.n = new b();
        VSWatermark r0 = new VSWatermark();
        r0.position = -1L;
        ArrayList r1 = new ArrayList();
        r1.add(a());
        r1.add(a());
        r0.vsWatermarkIcon = r1;
        this.o = r0;
        this.p = EpisodeMod.EpisodeStageType.UNKNOWN;
        this.q = "";
    }

    public static List<a> b() {
        String r0 = t.a().getCurrentUserId();
        ArrayList r1 = new ArrayList();
        Cursor r2 = c.query(new String[]{LiveEndPageData.TAG_TITLE, "download_size", "total_size", "time", "state", "error_code", "season_name", "season_id", "cover_url", "definition", "video_id", "episode_id", "video_key", "video_duration", "current_period", "item_id", "style", "position", "vertical_url", "vertical_width", "vertical_margin_l", "vertical_margin_p", "horizontal_url", "horizontal_width", "horizontal_margin_l", "horizontal_margin_p", "episode_stage_type", "download_uid"}, "download_uid=? OR download_uid IS NULL", new String[]{r0}, null, null, String.format("%s DESC", new Object[]{"time"}));
        if (r2 != null) goto L16;
        return null;
    L16:
        if (r2.moveToNext() == false) goto L14;
        a r3 = new a();     // Catch: Throwable -> L12
        r3.c = r2.getString(0);     // Catch: Throwable -> L12
        r3.n.a = r2.getLong(1);     // Catch: Throwable -> L12
        r3.n.b = r2.getLong(2);     // Catch: Throwable -> L12
        r3.n.e = r2.getLong(3);     // Catch: Throwable -> L12
        r3.n.c = r2.getInt(4);     // Catch: Throwable -> L12
        r3.n.d = r2.getInt(5);     // Catch: Throwable -> L12
        r3.d = r2.getString(6);     // Catch: Throwable -> L12
        r3.e = r2.getString(7);     // Catch: Throwable -> L12
        r3.f = r2.getString(8);     // Catch: Throwable -> L12
        r3.h = r2.getString(9);     // Catch: Throwable -> L12
        r3.a = r2.getString(10);     // Catch: Throwable -> L12
        r3.l = r2.getLong(11);     // Catch: Throwable -> L12
        r3.n.f = r2.getString(12);     // Catch: Throwable -> L12
        r3.g = r2.getLong(13);     // Catch: Throwable -> L12
        r3.b = r2.getString(14);     // Catch: Throwable -> L12
        r3.k = r2.getString(15);     // Catch: Throwable -> L12
        r3.m = r2.getInt(16);     // Catch: Throwable -> L12
        r3.o.position = Long.valueOf(r2.getLong(17));     // Catch: Throwable -> L12
        r3.e().set(0, r2.getString(18));     // Catch: Throwable -> L12
        r3.f().iconWidth = Long.valueOf(r2.getLong(19));     // Catch: Throwable -> L12
        r3.f().landscapeMargin = Long.valueOf(r2.getLong(20));     // Catch: Throwable -> L12
        r3.f().portraitMargin = Long.valueOf(r2.getLong(21));     // Catch: Throwable -> L12
        r3.c().set(0, r2.getString(22));     // Catch: Throwable -> L12
        r3.d().iconWidth = Long.valueOf(r2.getLong(23));     // Catch: Throwable -> L12
        r3.d().landscapeMargin = Long.valueOf(r2.getLong(24));     // Catch: Throwable -> L12
        r3.d().portraitMargin = Long.valueOf(r2.getLong(25));     // Catch: Throwable -> L12
        r1.add(r3);     // Catch: Throwable -> L12
        r3.p = r2.getInt(26);     // Catch: Throwable -> L12
        r3.q = r2.getString(27);     // Catch: Throwable -> L12
    L14:
        r2.close();     // Catch: Exception -> L13
    L11:
        return r1;
    }

    public final List<String> c() {
        k r0 = d().icon;
        if (r0 != null) goto L6;
        r0 = (k) f.c(k.class);
        ArrayList r1 = new ArrayList();
        r1.add("");
        r0.setUrls(r1);
        d().icon = r0;
    L6:
        return r0.getUrls();
    }

    public final List<String> e() {
        k r0 = f().icon;
        if (r0 != null) goto L6;
        r0 = (k) f.c(k.class);
        ArrayList r1 = new ArrayList();
        r1.add("");
        r0.setUrls(r1);
        f().icon = r0;
    L6:
        return r0.getUrls();
    }

    public static int delete(String r1, String[] r2) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return 0;
    L7:
        return c.delete(r1, r2);
    }
}
