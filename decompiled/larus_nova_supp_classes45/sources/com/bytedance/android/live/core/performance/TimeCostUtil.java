package com.bytedance.android.live.core.performance;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class TimeCostUtil {
    public static final /* synthetic */ int a = 0;

    public static final enum Tag extends Enum<Tag> {
        public static final Tag CreateLive = null;
        public static final Tag CreateStartLivePreview = null;
        public static final Tag LiveFeedInit = null;
        public static final Tag LiveFeedPreview = null;
        public static final Tag LiveFeedScroll = null;
        public static final Tag LivePk = null;
        public static final Tag ScrollWatchLivePlay = null;
        public static final Tag ShowBEFViewGift = null;
        public static final Tag ShowBInteractionFirstWidget = null;
        public static final Tag ShowBarrage = null;
        public static final Tag ShowCInteractionFirstWidget = null;
        public static final Tag ShowVideoGift = null;
        public static final Tag StartLivePlay = null;
        public static final /* synthetic */ Tag[] a = null;

        static {
            Tag r0 = new Tag("LiveFeedInit", 0);
            LiveFeedInit = r0;
            Tag r1 = new Tag("LiveFeedPreview", 1);
            LiveFeedPreview = r1;
            Tag r3 = new Tag("LiveFeedScroll", 2);
            LiveFeedScroll = r3;
            Tag r5 = new Tag("StartLivePlay", 3);
            StartLivePlay = r5;
            Tag r7 = new Tag("ScrollWatchLivePlay", 4);
            ScrollWatchLivePlay = r7;
            Tag r9 = new Tag("CreateStartLivePreview", 5);
            CreateStartLivePreview = r9;
            Tag r11 = new Tag("CreateLive", 6);
            CreateLive = r11;
            Tag r13 = new Tag("ShowBInteractionFirstWidget", 7);
            ShowBInteractionFirstWidget = r13;
            Tag r15 = new Tag("ShowVideoGift", 8);
            ShowVideoGift = r15;
            Tag r14 = new Tag("ShowBarrage", 9);
            ShowBarrage = r14;
            Tag r12 = new Tag("ShowCInteractionFirstWidget", 10);
            ShowCInteractionFirstWidget = r12;
            Tag r16 = new Tag("LivePk", 11);
            LivePk = r16;
            Tag r8 = new Tag("ShowBEFViewGift", 12);
            ShowBEFViewGift = r8;
            a = new Tag[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r16, r8};
        }

        public static Tag[] values() {
            return (Tag[]) a.clone();
        }

        public static Tag valueOf(String r1) {
            return (Tag) r27.a.a(Tag.class, r1);
        }

        public Tag(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        new ConcurrentHashMap(200);
        new ConcurrentHashMap(200);
    }

    public static HashMap<String, String> a(String r1, String r2) {
        HashMap<String, String> r0 = new HashMap();
        r0.put(r1, r2);
        return r0;
    }
}
