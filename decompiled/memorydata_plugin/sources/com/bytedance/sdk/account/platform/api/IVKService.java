package com.bytedance.sdk.account.platform.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IVKService extends b {

    public static final enum VKPermission extends Enum<VKPermission> {
        private static final /* synthetic */ VKPermission[] $VALUES = null;
        public static final VKPermission ADS = null;
        public static final VKPermission AUDIO = null;
        public static final VKPermission DOCS = null;
        public static final VKPermission EMAIL = null;
        public static final VKPermission FRIENDS = null;
        public static final VKPermission GROUPS = null;
        public static final VKPermission MARKET = null;
        public static final VKPermission MESSAGES = null;
        public static final VKPermission NOTES = null;
        public static final VKPermission NOTIFICATIONS = null;
        public static final VKPermission NOTIFY = null;
        public static final VKPermission OFFLINE = null;
        public static final VKPermission PAGES = null;
        public static final VKPermission PHONE = null;
        public static final VKPermission PHOTOS = null;
        public static final VKPermission STATS = null;
        public static final VKPermission STATUS = null;
        public static final VKPermission STORIES = null;
        public static final VKPermission VIDEO = null;
        public static final VKPermission WALL = null;

        static {
            VKPermission r0 = new VKPermission("NOTIFY", 0);
            NOTIFY = r0;
            VKPermission r1 = new VKPermission("FRIENDS", 1);
            FRIENDS = r1;
            VKPermission r3 = new VKPermission("PHOTOS", 2);
            PHOTOS = r3;
            VKPermission r5 = new VKPermission("AUDIO", 3);
            AUDIO = r5;
            VKPermission r7 = new VKPermission("VIDEO", 4);
            VIDEO = r7;
            VKPermission r9 = new VKPermission("STORIES", 5);
            STORIES = r9;
            VKPermission r11 = new VKPermission("PAGES", 6);
            PAGES = r11;
            VKPermission r13 = new VKPermission("STATUS", 7);
            STATUS = r13;
            VKPermission r15 = new VKPermission("NOTES", 8);
            NOTES = r15;
            VKPermission r14 = new VKPermission("MESSAGES", 9);
            MESSAGES = r14;
            VKPermission r12 = new VKPermission("WALL", 10);
            WALL = r12;
            VKPermission r10 = new VKPermission("ADS", 11);
            ADS = r10;
            VKPermission r8 = new VKPermission("OFFLINE", 12);
            OFFLINE = r8;
            VKPermission r6 = new VKPermission("DOCS", 13);
            DOCS = r6;
            VKPermission r4 = new VKPermission("GROUPS", 14);
            GROUPS = r4;
            VKPermission r2 = new VKPermission("NOTIFICATIONS", 15);
            NOTIFICATIONS = r2;
            VKPermission r16 = new VKPermission("STATS", 16);
            STATS = r16;
            VKPermission r17 = new VKPermission("EMAIL", 17);
            EMAIL = r17;
            VKPermission r18 = new VKPermission("MARKET", 18);
            MARKET = r18;
            VKPermission r19 = new VKPermission("PHONE", 19);
            PHONE = r19;
            $VALUES = new VKPermission[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
        }

        private VKPermission(String r1, int r2) {
            super(r1, r2);
        }

        public static VKPermission valueOf(String r2) {
            return (VKPermission) ZeusTransformUtils.preCheckCast(Enum.valueOf(VKPermission.class, r2), VKPermission.class, "com.obric.memorydata.plugin");
        }

        public static VKPermission[] values() {
            return (VKPermission[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VKPermission[].class, "com.obric.memorydata.plugin");
        }
    }
}
