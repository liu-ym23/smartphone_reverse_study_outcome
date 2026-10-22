package com.obric.memorydata.memory.island.gr;

import android.app.PendingIntent;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\bN\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b \b\u0087\b\u0018\u0000 \u007f2\u00020\u0001:\u0001\u007fB\u008d\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010]\u001a\u00020^J\u0010\u0010_\u001a\u00020`2\b\b\u0002\u0010a\u001a\u00020\rJ\b\u0010b\u001a\u00020\rH\u0016J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010g\u001a\u00020\tHÆ\u0003J\t\u0010h\u001a\u00020\u000bHÆ\u0003J\t\u0010i\u001a\u00020\rHÆ\u0003J\t\u0010j\u001a\u00020\u000fHÆ\u0003J\t\u0010k\u001a\u00020\u000fHÆ\u0003J\t\u0010l\u001a\u00020\u000fHÆ\u0003J\t\u0010m\u001a\u00020\u000fHÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010@J\u000b\u0010o\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010@J\u000b\u0010s\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010@J\u0010\u0010v\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010@J\u0010\u0010w\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010UJ\u0010\u0010x\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010@J\u0010\u0010y\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010UJ\u0094\u0002\u0010z\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010{J\u0013\u0010|\u001a\u00020\u000f2\b\u0010}\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010~\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00102\"\u0004\bE\u00104R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00102\"\u0004\bG\u00104R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00102\"\u0004\bI\u00104R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\bJ\u0010@\"\u0004\bK\u0010BR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00102\"\u0004\bM\u00104R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00102\"\u0004\bO\u00104R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\bP\u0010@\"\u0004\bQ\u0010BR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\bR\u0010@\"\u0004\bS\u0010BR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010X\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\bY\u0010@\"\u0004\bZ\u0010BR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010X\u001a\u0004\b[\u0010U\"\u0004\b\\\u0010W¨\u0006\u0080\u0001"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandSession;", "", "collapseWidget", "Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "expandWidget", "smallCollapseWidget", MemorySourceLinkType.INTENT, "Landroid/app/PendingIntent;", "smallIconResId", "", "taskId", "", "business", "", "canFrontShow", "", "enableFloat", "islandFirstFloat", "updatable", LocationMonitorConst.TIMEOUT, IslandSession.REOPEN_VALUE_REOPEN, "ticker", "tickerPic", "tickerPicResId", "aodTitle", "aodPic", "aodPicResId", "islandProperty", "islandOrder", "islandTimeout", "dismissIsland", "<init>", "(Lcom/obric/memorydata/memory/island/gr/IslandWidget;Lcom/obric/memorydata/memory/island/gr/IslandWidget;Lcom/obric/memorydata/memory/island/gr/IslandWidget;Landroid/app/PendingIntent;IJLjava/lang/String;ZZZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCollapseWidget", "()Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "getExpandWidget", "getSmallCollapseWidget", "getIntent", "()Landroid/app/PendingIntent;", "setIntent", "(Landroid/app/PendingIntent;)V", "getSmallIconResId", "()I", "setSmallIconResId", "(I)V", "getTaskId", "()J", "setTaskId", "(J)V", "getBusiness", "()Ljava/lang/String;", "setBusiness", "(Ljava/lang/String;)V", "getCanFrontShow", "()Z", "setCanFrontShow", "(Z)V", "getEnableFloat", "setEnableFloat", "getIslandFirstFloat", "setIslandFirstFloat", "getUpdatable", "setUpdatable", "getTimeout", "()Ljava/lang/Integer;", "setTimeout", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReopen", "setReopen", "getTicker", "setTicker", "getTickerPic", "setTickerPic", "getTickerPicResId", "setTickerPicResId", "getAodTitle", "setAodTitle", "getAodPic", "setAodPic", "getAodPicResId", "setAodPicResId", "getIslandProperty", "setIslandProperty", "getIslandOrder", "()Ljava/lang/Boolean;", "setIslandOrder", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getIslandTimeout", "setIslandTimeout", "getDismissIsland", "setDismissIsland", "toJSONObject", "Lorg/json/JSONObject;", "logSummary", "", "prefix", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Lcom/obric/memorydata/memory/island/gr/IslandWidget;Lcom/obric/memorydata/memory/island/gr/IslandWidget;Lcom/obric/memorydata/memory/island/gr/IslandWidget;Landroid/app/PendingIntent;IJLjava/lang/String;ZZZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/island/gr/IslandSession;", "equals", "other", "hashCode", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IslandSession {
    public static final a Companion = null;
    public static final String REOPEN_VALUE_CLOSE = "close";
    public static final String REOPEN_VALUE_REOPEN = "reopen";
    private static final String TAG = "IslandSession";
    private String aodPic;
    private Integer aodPicResId;
    private String aodTitle;
    private String business;
    private boolean canFrontShow;
    private final IslandWidget collapseWidget;
    private Boolean dismissIsland;
    private boolean enableFloat;
    private final IslandWidget expandWidget;
    private PendingIntent intent;
    private boolean islandFirstFloat;
    private Boolean islandOrder;
    private Integer islandProperty;
    private Integer islandTimeout;
    private String reopen;
    private final IslandWidget smallCollapseWidget;
    private int smallIconResId;
    private long taskId;
    private String ticker;
    private String tickerPic;
    private Integer tickerPicResId;
    private Integer timeout;
    private boolean updatable;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandSession$Companion;", "", "<init>", "()V", "TAG", "", "REOPEN_VALUE_REOPEN", "REOPEN_VALUE_CLOSE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public IslandSession() {
        this(null, null, null, null, 0, 0, null, false, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public IslandSession(IslandWidget r5, IslandWidget r6, IslandWidget r7, PendingIntent r8, int r9, long r10, String r12, boolean r13, boolean r14, boolean r15, boolean r16, Integer r17, String r18, String r19, String r20, Integer r21, String r22, String r23, Integer r24, Integer r25, Boolean r26, Integer r27, Boolean r28) {
        Intrinsics.checkNotNullParameter(r12, "business");
        this.collapseWidget = r5;
        this.expandWidget = r6;
        this.smallCollapseWidget = r7;
        this.intent = r8;
        this.smallIconResId = r9;
        this.taskId = r10;
        this.business = r12;
        this.canFrontShow = r13;
        this.enableFloat = r14;
        this.islandFirstFloat = r15;
        this.updatable = r16;
        this.timeout = r17;
        this.reopen = r18;
        this.ticker = r19;
        this.tickerPic = r20;
        this.tickerPicResId = r21;
        this.aodTitle = r22;
        this.aodPic = r23;
        this.aodPicResId = r24;
        this.islandProperty = r25;
        this.islandOrder = r26;
        this.islandTimeout = r27;
        this.dismissIsland = r28;
    }

    public /* synthetic */ IslandSession(IslandWidget r25, IslandWidget r26, IslandWidget r27, PendingIntent r28, int r29, long r30, String r32, boolean r33, boolean r34, boolean r35, boolean r36, Integer r37, String r38, String r39, String r40, Integer r41, String r42, String r43, Integer r44, Integer r45, Boolean r46, Integer r47, Boolean r48, int r49, DefaultConstructorMarker r50) {
        if ((r49 & 1) == 0) goto L5;
        IslandWidget r1 = null;
    L7:
        if ((r49 & 2) == 0) goto L9;
        IslandWidget r3 = null;
    L11:
        if ((r49 & 4) == 0) goto L13;
        IslandWidget r4 = null;
    L15:
        if ((r49 & 8) == 0) goto L17;
        PendingIntent r5 = null;
    L18:
        boolean r7 = false;
        if ((r49 & 16) == 0) goto L21;
        int r6 = 0;
    L23:
        if ((r49 & 32) == 0) goto L25;
        long r8 = 0;
    L27:
        if ((r49 & 64) == 0) goto L29;
        String r10 = SlardarSettingsConstants.PERF_KEY_MEMORY;
    L31:
        if ((r49 & 128) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r49 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r49 & 512) != 0) goto L43;
        r7 = r35;
    L43:
        if ((r49 & 1024) == 0) goto L45;
        boolean r13 = true;
    L47:
        if ((r49 & 2048) == 0) goto L49;
        Integer r14 = null;
    L51:
        if ((r49 & 4096) == 0) goto L53;
        String r15 = REOPEN_VALUE_REOPEN;
    L55:
        if ((r49 & 8192) == 0) goto L57;
        String r2 = null;
    L58:
        String r310 = r2;
        if ((r49 & 16384) == 0) goto L61;
        String r9 = null;
    L63:
        if ((r49 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r49 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r49 & 131072) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r49 & 262144) == 0) goto L77;
        Integer r19 = null;
    L79:
        if ((r49 & 524288) == 0) goto L81;
        Integer r20 = null;
    L83:
        if ((r49 & 1048576) == 0) goto L85;
        Boolean r21 = null;
    L87:
        if ((r49 & 2097152) == 0) goto L89;
        Integer r22 = null;
    L91:
        if ((r49 & 4194304) == 0) goto L93;
        Boolean r0 = null;
    L94:
        this(r1, r3, r4, r5, r6, r8, r10, r11, r12, r7, r13, r14, r15, r310, r9, r16, r17, r18, r19, r20, r21, r22, r0);
        return;
    L93:
        r0 = r48;
        goto L94
    L89:
        r22 = r47;
        goto L91
    L85:
        r21 = r46;
        goto L87
    L81:
        r20 = r45;
        goto L83
    L77:
        r19 = r44;
        goto L79
    L73:
        r18 = r43;
        goto L75
    L69:
        r17 = r42;
        goto L71
    L65:
        r16 = r41;
        goto L67
    L61:
        r9 = r40;
        goto L63
    L57:
        r2 = r39;
        goto L58
    L53:
        r15 = r38;
        goto L55
    L49:
        r14 = r37;
        goto L51
    L45:
        r13 = r36;
        goto L47
    L37:
        r12 = r34;
        goto L39
    L33:
        r11 = r33;
        goto L35
    L29:
        r10 = r32;
        goto L31
    L25:
        r8 = r30;
        goto L27
    L21:
        r6 = r29;
        goto L23
    L17:
        r5 = r28;
        goto L18
    L13:
        r4 = r27;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r1 = r25;
        goto L7
    }

    public static /* synthetic */ IslandSession copy$default(IslandSession r17, IslandWidget r18, IslandWidget r19, IslandWidget r20, PendingIntent r21, int r22, long r23, String r25, boolean r26, boolean r27, boolean r28, boolean r29, Integer r30, String r31, String r32, String r33, Integer r34, String r35, String r36, Integer r37, Integer r38, Boolean r39, Integer r40, Boolean r41, int r42, Object r43) {
        if ((r42 & 1) == 0) goto L5;
        IslandWidget r2 = r17.collapseWidget;
    L7:
        if ((r42 & 2) == 0) goto L9;
        IslandWidget r3 = r17.expandWidget;
    L11:
        if ((r42 & 4) == 0) goto L13;
        IslandWidget r4 = r17.smallCollapseWidget;
    L15:
        if ((r42 & 8) == 0) goto L17;
        PendingIntent r5 = r17.intent;
    L19:
        if ((r42 & 16) == 0) goto L21;
        int r6 = r17.smallIconResId;
    L23:
        if ((r42 & 32) == 0) goto L25;
        long r7 = r17.taskId;
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r9 = r17.business;
    L31:
        if ((r42 & 128) == 0) goto L33;
        boolean r10 = r17.canFrontShow;
    L35:
        if ((r42 & 256) == 0) goto L37;
        boolean r11 = r17.enableFloat;
    L39:
        if ((r42 & 512) == 0) goto L41;
        boolean r12 = r17.islandFirstFloat;
    L43:
        if ((r42 & 1024) == 0) goto L45;
        boolean r13 = r17.updatable;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        Integer r14 = r17.timeout;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r15 = r17.reopen;
    L54:
        String r310 = r15;
        if ((r42 & 8192) == 0) goto L57;
        String r16 = r17.ticker;
    L58:
        String r311 = r16;
        if ((r42 & 16384) == 0) goto L61;
        String r110 = r17.tickerPic;
    L62:
        String r312 = r110;
        if ((r42 & 32768) == 0) goto L65;
        Integer r111 = r17.tickerPicResId;
    L66:
        Integer r313 = r111;
        if ((r42 & 65536) == 0) goto L69;
        String r112 = r17.aodTitle;
    L70:
        String r314 = r112;
        if ((r42 & 131072) == 0) goto L73;
        String r113 = r17.aodPic;
    L74:
        String r315 = r113;
        if ((r42 & 262144) == 0) goto L77;
        Integer r114 = r17.aodPicResId;
    L78:
        Integer r316 = r114;
        if ((r42 & 524288) == 0) goto L81;
        Integer r115 = r17.islandProperty;
    L82:
        Integer r317 = r115;
        if ((r42 & 1048576) == 0) goto L85;
        Boolean r116 = r17.islandOrder;
    L86:
        Boolean r318 = r116;
        if ((r42 & 2097152) == 0) goto L89;
        Integer r117 = r17.islandTimeout;
    L91:
        if ((r42 & 4194304) == 0) goto L93;
        Boolean r1 = r17.dismissIsland;
    L95:
        return r17.copy(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r117, r1);
    L93:
        r1 = r41;
        goto L95
    L89:
        r117 = r40;
        goto L91
    L85:
        r116 = r39;
        goto L86
    L81:
        r115 = r38;
        goto L82
    L77:
        r114 = r37;
        goto L78
    L73:
        r113 = r36;
        goto L74
    L69:
        r112 = r35;
        goto L70
    L65:
        r111 = r34;
        goto L66
    L61:
        r110 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public static /* synthetic */ void logSummary$default(IslandSession r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.logSummary(r1);
    }

    public final IslandWidget component1() {
        return this.collapseWidget;
    }

    public final boolean component10() {
        return this.islandFirstFloat;
    }

    public final boolean component11() {
        return this.updatable;
    }

    public final Integer component12() {
        return this.timeout;
    }

    public final String component13() {
        return this.reopen;
    }

    public final String component14() {
        return this.ticker;
    }

    public final String component15() {
        return this.tickerPic;
    }

    public final Integer component16() {
        return this.tickerPicResId;
    }

    public final String component17() {
        return this.aodTitle;
    }

    public final String component18() {
        return this.aodPic;
    }

    public final Integer component19() {
        return this.aodPicResId;
    }

    public final IslandWidget component2() {
        return this.expandWidget;
    }

    public final Integer component20() {
        return this.islandProperty;
    }

    public final Boolean component21() {
        return this.islandOrder;
    }

    public final Integer component22() {
        return this.islandTimeout;
    }

    public final Boolean component23() {
        return this.dismissIsland;
    }

    public final IslandWidget component3() {
        return this.smallCollapseWidget;
    }

    public final PendingIntent component4() {
        return this.intent;
    }

    public final int component5() {
        return this.smallIconResId;
    }

    public final long component6() {
        return this.taskId;
    }

    public final String component7() {
        return this.business;
    }

    public final boolean component8() {
        return this.canFrontShow;
    }

    public final boolean component9() {
        return this.enableFloat;
    }

    public final IslandSession copy(IslandWidget r27, IslandWidget r28, IslandWidget r29, PendingIntent r30, int r31, long r32, String r34, boolean r35, boolean r36, boolean r37, boolean r38, Integer r39, String r40, String r41, String r42, Integer r43, String r44, String r45, Integer r46, Integer r47, Boolean r48, Integer r49, Boolean r50) {
        Intrinsics.checkNotNullParameter(r34, "business");
        return new IslandSession(r27, r28, r29, r30, r31, r32, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, IslandSession.class) == true) goto L8;
        return false;
    L8:
        IslandSession r10 = (IslandSession) ZeusTransformUtils.preCheckCast(r9, IslandSession.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.collapseWidget, r10.collapseWidget) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expandWidget, r10.expandWidget) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.smallCollapseWidget, r10.smallCollapseWidget) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.intent, r10.intent) == true) goto L21;
        return false;
    L21:
        if (this.smallIconResId == r10.smallIconResId) goto L24;
        return false;
    L24:
        if (this.taskId == r10.taskId) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.business, r10.business) == true) goto L30;
        return false;
    L30:
        if (this.canFrontShow == r10.canFrontShow) goto L33;
        return false;
    L33:
        if (this.enableFloat == r10.enableFloat) goto L36;
        return false;
    L36:
        if (this.islandFirstFloat == r10.islandFirstFloat) goto L39;
        return false;
    L39:
        if (this.updatable == r10.updatable) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.timeout, r10.timeout) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.reopen, r10.reopen) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ticker, r10.ticker) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.tickerPic, r10.tickerPic) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.tickerPicResId, r10.tickerPicResId) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.aodTitle, r10.aodTitle) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.aodPic, r10.aodPic) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.aodPicResId, r10.aodPicResId) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.islandProperty, r10.islandProperty) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.islandOrder, r10.islandOrder) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.islandTimeout, r10.islandTimeout) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.dismissIsland, r10.dismissIsland) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final String getAodPic() {
        return this.aodPic;
    }

    public final Integer getAodPicResId() {
        return this.aodPicResId;
    }

    public final String getAodTitle() {
        return this.aodTitle;
    }

    public final String getBusiness() {
        return this.business;
    }

    public final boolean getCanFrontShow() {
        return this.canFrontShow;
    }

    public final IslandWidget getCollapseWidget() {
        return this.collapseWidget;
    }

    public final Boolean getDismissIsland() {
        return this.dismissIsland;
    }

    public final boolean getEnableFloat() {
        return this.enableFloat;
    }

    public final IslandWidget getExpandWidget() {
        return this.expandWidget;
    }

    public final PendingIntent getIntent() {
        return this.intent;
    }

    public final boolean getIslandFirstFloat() {
        return this.islandFirstFloat;
    }

    public final Boolean getIslandOrder() {
        return this.islandOrder;
    }

    public final Integer getIslandProperty() {
        return this.islandProperty;
    }

    public final Integer getIslandTimeout() {
        return this.islandTimeout;
    }

    public final String getReopen() {
        return this.reopen;
    }

    public final IslandWidget getSmallCollapseWidget() {
        return this.smallCollapseWidget;
    }

    public final int getSmallIconResId() {
        return this.smallIconResId;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public final String getTicker() {
        return this.ticker;
    }

    public final String getTickerPic() {
        return this.tickerPic;
    }

    public final Integer getTickerPicResId() {
        return this.tickerPicResId;
    }

    public final Integer getTimeout() {
        return this.timeout;
    }

    public final boolean getUpdatable() {
        return this.updatable;
    }

    public int hashCode() {
        IslandWidget r0 = this.collapseWidget;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        IslandWidget r4 = this.expandWidget;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        IslandWidget r7 = this.smallCollapseWidget;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        PendingIntent r10 = this.intent;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((((((((((((((r9 + r11) * 31) + Integer.hashCode(this.smallIconResId)) * 31) + Long.hashCode(this.taskId)) * 31) + this.business.hashCode()) * 31) + Boolean.hashCode(this.canFrontShow)) * 31) + Boolean.hashCode(this.enableFloat)) * 31) + Boolean.hashCode(this.islandFirstFloat)) * 31) + Boolean.hashCode(this.updatable)) * 31;
        Integer r13 = this.timeout;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.reopen;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.ticker;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.tickerPic;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.tickerPicResId;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.aodTitle;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.aodPic;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.aodPicResId;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.islandProperty;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Boolean r40 = this.islandOrder;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Integer r43 = this.islandTimeout;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Boolean r46 = this.dismissIsland;
        if (r46 == null) goto L67;
        r1 = r46.hashCode();
    L67:
        return r45 + r1;
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final void logSummary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "prefix");
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append(r4).append("IslandSession summary: taskId=").append(this.taskId).append(", business=").append(this.business).append(", collapseWidget=");
        IslandWidget r1 = this.collapseWidget;
        String r2 = "null";
        if (r1 == null) goto L6;
        String r3 = r1.getTemplateId();
        if (r3 == null) goto L6;
    L7:
        StringBuilder r6 = r5.append(r3).append(", expandWidget=");
        IslandWidget r7 = this.expandWidget;
        if (r7 == null) goto L11;
        String r8 = r7.getTemplateId();
        if (r8 == null) goto L11;
    L12:
        StringBuilder r9 = r6.append(r8).append(", smallCollapseWidget=");
        IslandWidget r10 = this.smallCollapseWidget;
        if (r10 == null) goto L18;
        String r11 = r10.getTemplateId();
        if (r11 == null) goto L18;
        r2 = r11;
    L18:
        StringBuilder r12 = r9.append(r2).append(", hasIntent=");
        if (this.intent == null) goto L21;
        boolean r13 = true;
    L22:
        r0.debug(TAG, r12.append(r13).append(", canFrontShow=").append(this.canFrontShow).append(", enableFloat=").append(this.enableFloat).append(", updatable=").append(this.updatable).toString());
        return;
    L21:
        r13 = false;
    L11:
        r8 = "null";
    L6:
        r3 = "null";
        goto L7
    }

    public final void setAodPic(String r1) {
        this.aodPic = r1;
    }

    public final void setAodPicResId(Integer r1) {
        this.aodPicResId = r1;
    }

    public final void setAodTitle(String r1) {
        this.aodTitle = r1;
    }

    public final void setBusiness(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.business = r2;
    }

    public final void setCanFrontShow(boolean r1) {
        this.canFrontShow = r1;
    }

    public final void setDismissIsland(Boolean r1) {
        this.dismissIsland = r1;
    }

    public final void setEnableFloat(boolean r1) {
        this.enableFloat = r1;
    }

    public final void setIntent(PendingIntent r1) {
        this.intent = r1;
    }

    public final void setIslandFirstFloat(boolean r1) {
        this.islandFirstFloat = r1;
    }

    public final void setIslandOrder(Boolean r1) {
        this.islandOrder = r1;
    }

    public final void setIslandProperty(Integer r1) {
        this.islandProperty = r1;
    }

    public final void setIslandTimeout(Integer r1) {
        this.islandTimeout = r1;
    }

    public final void setReopen(String r1) {
        this.reopen = r1;
    }

    public final void setSmallIconResId(int r1) {
        this.smallIconResId = r1;
    }

    public final void setTaskId(long r1) {
        this.taskId = r1;
    }

    public final void setTicker(String r1) {
        this.ticker = r1;
    }

    public final void setTickerPic(String r1) {
        this.tickerPic = r1;
    }

    public final void setTickerPicResId(Integer r1) {
        this.tickerPicResId = r1;
    }

    public final void setTimeout(Integer r1) {
        this.timeout = r1;
    }

    public final void setUpdatable(boolean r1) {
        this.updatable = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("toJSONObject: business=").append(this.business).append(", taskId=").append(this.taskId).append(", hasCollapse=");
        boolean r3 = false;
        if (this.collapseWidget == null) goto L5;
        boolean r2 = true;
    L6:
        StringBuilder r4 = r1.append(r2).append(", hasExpand=");
        if (this.expandWidget == null) goto L9;
        boolean r5 = true;
    L10:
        StringBuilder r6 = r4.append(r5).append(", hasSmallCollapse=");
        if (this.smallCollapseWidget == null) goto L13;
        r3 = true;
    L13:
        r0.debug(TAG, r6.append(r3).toString());
        JSONObject r7 = new JSONObject();
        r7.put("protocol", 1);
        r7.put("business", this.business);
        r7.put("enableFloat", this.enableFloat);
        r7.put("islandFirstFloat", this.islandFirstFloat);
        r7.put("updatable", this.updatable);
        Integer r8 = this.timeout;
        if (r8 == null) goto L16;
        r7.put(LocationMonitorConst.TIMEOUT, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
    L16:
        String r9 = this.reopen;
        if (r9 == null) goto L19;
        r7.put(REOPEN_VALUE_REOPEN, r9);
    L19:
        String r10 = this.ticker;
        if (r10 == null) goto L22;
        r7.put("ticker", r10);
    L22:
        String r11 = this.tickerPic;
        if (r11 == null) goto L25;
        r7.put("tickerPic", r11);
    L25:
        String r12 = this.aodTitle;
        if (r12 == null) goto L28;
        r7.put("aodTitle", r12);
    L28:
        String r13 = this.aodPic;
        if (r13 == null) goto L31;
        r7.put("aodPic", r13);
    L31:
        JSONObject r14 = new JSONObject();
        Integer r15 = this.islandProperty;
        if (r15 == null) goto L34;
        r14.put("islandProperty", ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).intValue());
    L34:
        Boolean r16 = this.islandOrder;
        if (r16 == null) goto L37;
        r14.put("islandOrder", r16.booleanValue());
    L37:
        Integer r17 = this.islandTimeout;
        if (r17 == null) goto L40;
        r14.put("islandTimeout", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue());
    L40:
        Boolean r18 = this.dismissIsland;
        if (r18 == null) goto L43;
        r14.put("dismissIsland", r18.booleanValue());
    L43:
        IslandWidget r19 = this.collapseWidget;
        if (r19 == null) goto L46;
        r14.put("bigIslandArea", r19.getTemplateData().toJSONObject());
    L46:
        IslandWidget r20 = this.smallCollapseWidget;
        if (r20 == null) goto L49;
        r14.put("smallIslandArea", r20.getTemplateData().toJSONObject());
    L49:
        r7.put("param_island", r14);
        IslandWidget r21 = this.expandWidget;
        if (r21 == null) goto L55;
        JSONObject r22 = r21.getTemplateData().toJSONObject();
        RunLog r23 = RunLog.INSTANCE;
        StringBuilder r24 = new StringBuilder().append("toJSONObject: expandJSON keys=");
        Iterator<String> r25 = r22.keys();
        Intrinsics.checkNotNullExpressionValue(r25, "keys(...)");
        r23.debug(TAG, r24.append(SequencesKt.toList(SequencesKt.asSequence(r25))).toString());
        Iterator<String> r26 = r22.keys();
        Intrinsics.checkNotNullExpressionValue(r26, "keys(...)");
    L53:
        if (r26.hasNext() == false) goto L55;
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26.next(), String.class, "com.obric.memorydata.plugin");
        r7.put(r27, r22.get(r27));
    L55:
        return r7;
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("IslandSession(taskId=").append(this.taskId).append(", business=").append(this.business).append(", collapse=");
        IslandWidget r1 = this.collapseWidget;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getTemplateId();
    L6:
        StringBuilder r4 = r0.append(r3).append(", expand=");
        IslandWidget r5 = this.expandWidget;
        if (r5 == null) goto L9;
        String r6 = r5.getTemplateId();
    L10:
        StringBuilder r7 = r4.append(r6).append(", smallCollapse=");
        IslandWidget r8 = this.smallCollapseWidget;
        if (r8 == null) goto L14;
        r2 = r8.getTemplateId();
    L14:
        return r7.append(r2).append(')').toString();
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
