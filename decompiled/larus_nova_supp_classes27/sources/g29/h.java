package g29;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public static final void a(String r2, String r3, int r4, int r5, long r6) {
        JSONObject r0 = new JSONObject();
        r0.put("event_type", r2);
        r0.put("fps_tag", r3);
        switch(r4) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        String r7 = "unknown";
    L17:
        r0.put("type", r7);
        r0.put("position", r5);
        r0.put("duration", r6);
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("creation_feed_holder_trace");
        r9.a.merge(r8);
        r9.b();
        return;
    L5:
        r7 = "replica_entrance";
        goto L17
    L6:
        r7 = "creation_banned";
        goto L17
    L7:
        r7 = "image_to_image";
        goto L17
    L8:
        r7 = "video";
        goto L17
    L9:
        r7 = "self_private";
        goto L17
    L10:
        r7 = "ai_beautify";
        goto L17
    L11:
        r7 = "music";
        goto L17
    L12:
        r7 = "loading_and_retry";
        goto L17
    L13:
        r7 = "header";
        goto L17
    L14:
        r7 = "more";
        goto L17
    L15:
        r7 = "avatar";
        goto L17
    L16:
        r7 = "image";
        goto L17
    }
}
