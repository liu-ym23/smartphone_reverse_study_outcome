package com.bytedance.android.live.revlink.impl.pk.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IPkAudienceLoadService {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/service/IPkAudienceLoadService$LoadType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "MessageLoad", "RoomSyncLoad", "SEILoad", "OTHER", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LoadType extends Enum<LoadType> {
        public static final LoadType MessageLoad = null;
        public static final LoadType OTHER = null;
        public static final LoadType RoomSyncLoad = null;
        public static final LoadType SEILoad = null;
        public static final /* synthetic */ LoadType[] a = null;
        private final String type;

        static {
            LoadType r1 = new LoadType("MessageLoad", 0, "MessageLoad");
            MessageLoad = r1;
            LoadType r2 = new LoadType("RoomSyncLoad", 1, "RoomSyncLoad");
            RoomSyncLoad = r2;
            LoadType r3 = new LoadType("SEILoad", 2, "SEILoad");
            SEILoad = r3;
            LoadType r4 = new LoadType("OTHER", 3, "Other");
            OTHER = r4;
            a = new LoadType[]{r1, r2, r3, r4};
        }

        public static LoadType valueOf(String r1) {
            return (LoadType) r27.a.a(LoadType.class, r1);
        }

        public static LoadType[] values() {
            return (LoadType[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public LoadType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    void a();

    void reset();
}
