package com.larksuite.component.blockit.entity;

import com.larksuite.component.blockit.d;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum BlockTypeID extends Enum<BlockTypeID> {
    public static final BlockTypeID CALENDAR = null;
    public static final BlockTypeID CCM = null;
    public static final BlockTypeID CHAT = null;
    public static final BlockTypeID EVENT = null;
    public static final BlockTypeID MESSAGE = null;
    public static final BlockTypeID TODO = null;
    public static final /* synthetic */ BlockTypeID[] a = null;
    private String onlineValue;
    private String stagingValue;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BlockitEnv.values().length];
            a = r0;
            r0[BlockitEnv.STAGING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[BlockitEnv.PRE_RELEASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[BlockitEnv.ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        BlockTypeID r0 = new BlockTypeID("CHAT", 0, "blk_5f8f7ccdc2934001f9098d7e", "blk_5f9911efc34e8004f8d44a05");
        CHAT = r0;
        BlockTypeID r1 = new BlockTypeID("MESSAGE", 1, "blk_5f8f7ccdc2934001f9098a49", "blk_5f9911efc34e8004f8d44a06");
        MESSAGE = r1;
        BlockTypeID r2 = new BlockTypeID("EVENT", 2, "blk_604f3523070000133c9aca12", "blk_5f9911a7151940042e838a05");
        EVENT = r2;
        BlockTypeID r3 = new BlockTypeID("CALENDAR", 3, "blk_5f8f7ccba955c00192cf0cf3", "");
        CALENDAR = r3;
        BlockTypeID r5 = new BlockTypeID("CCM", 4, "blk_60506a33c3800013f81aca12", "blk_5f9911cb7bd60001404cca03");
        CCM = r5;
        BlockTypeID r7 = new BlockTypeID("TODO", 5, "blk_6050b23eebc00014d05aca15", "blk_5fe05d609999c003a2030a02");
        TODO = r7;
        a = new BlockTypeID[]{r0, r1, r2, r3, r5, r7};
    }

    public static BlockTypeID[] values() {
        return (BlockTypeID[]) a.clone();
    }

    public String getValue() {
        int r0 = a.a[((d) ApiUtils.getApi(d.class)).getEnv().ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L11;
        return this.stagingValue;
    L11:
        return this.onlineValue;
    L13:
        return this.stagingValue;
    }

    public static BlockTypeID valueOf(String r1) {
        return (BlockTypeID) r27.a.a(BlockTypeID.class, r1);
    }

    public BlockTypeID(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.stagingValue = r3;
        this.onlineValue = r4;
    }
}
