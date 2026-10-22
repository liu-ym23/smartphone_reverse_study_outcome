package com.bytedance.android.livesdk.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FollowStatusDataErrorEvent {
    public final com.bytedance.android.live.base.model.user.c0 a;
    public final FollowDataSource b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public static final enum FollowDataSource extends Enum<FollowDataSource> {
        public static final FollowDataSource END_LIVE_FOLLOW = null;
        public static final FollowDataSource ENTER_ROOM_FOLLOW = null;
        public static final FollowDataSource PROFILE_FOLLOW = null;
        public static final /* synthetic */ FollowDataSource[] a = null;
        String source;

        static {
            FollowDataSource r0 = new FollowDataSource("ENTER_ROOM_FOLLOW", 0, "enter_room_follow");
            ENTER_ROOM_FOLLOW = r0;
            FollowDataSource r1 = new FollowDataSource("PROFILE_FOLLOW", 1, "profile_follow");
            PROFILE_FOLLOW = r1;
            FollowDataSource r2 = new FollowDataSource("END_LIVE_FOLLOW", 2, "end_live_follow");
            END_LIVE_FOLLOW = r2;
            a = new FollowDataSource[]{r0, r1, r2};
        }

        public static FollowDataSource[] values() {
            return (FollowDataSource[]) a.clone();
        }

        public String getSource() {
            return this.source;
        }

        public static FollowDataSource valueOf(String r1) {
            return (FollowDataSource) r27.a.a(FollowDataSource.class, r1);
        }

        public FollowDataSource(String r1, int r2, String r3) {
            super(r1, r2);
            this.source = r3;
        }
    }

    public FollowStatusDataErrorEvent(com.bytedance.android.live.base.model.user.c0 r2, FollowDataSource r3, String r4, String r5, String r6, String r7) {
        this.a = null;
        this.b = null;
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
