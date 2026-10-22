package com.obric.memorydata.memory.memoryentity;

import android.content.ComponentName;
import android.graphics.Bitmap;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\bK\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020(¢\u0006\u0004\b)\u0010*J\b\u0010U\u001a\u00020\u0005H\u0016J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0011HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u001bHÆ\u0003J\t\u0010g\u001a\u00020\u0011HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010$HÆ\u0003J\t\u0010l\u001a\u00020&HÆ\u0003J\t\u0010m\u001a\u00020(HÆ\u0003J¤\u0002\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(HÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020\u00112\b\u0010q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010r\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bD\u00108R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010Q\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bR\u0010.R\u0013\u0010S\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bT\u0010.¨\u0006s"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "", "productType", "", "sourcePackageName", "", "sourceAppName", "sourceBitmap", "Landroid/graphics/Bitmap;", "_sourceText", "sourceBitmapFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "_sourceQuery", "sourceActivity", "Landroid/content/ComponentName;", "fixedIntent", "pageContextCaptureDisabled", "", "chatHistory", "refMemoryEntities", "", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "subIntent", "rawChatHistory", "sourceScreenshotTosKey", "logId", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "enableStream", "pageContextHandle", "Lcom/obric/memorydata/dc/PageContextHandle;", "buildControl", "Lcom/obric/memorydata/memory/llm/MemoryBuildControl;", "inAppAssociation", "Lcom/obric/memorydata/memory/memoryentity/InAppMemoryAssociation;", "sourceImageInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "sourceBitmapUploadResizeFactor", "", "currentTimeMillis", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;Ljava/lang/String;Landroid/content/ComponentName;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/logging/LogContext;ZLcom/obric/memorydata/dc/PageContextHandle;Lcom/obric/memorydata/memory/llm/MemoryBuildControl;Lcom/obric/memorydata/memory/memoryentity/InAppMemoryAssociation;Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;FJ)V", "getProductType", "()I", "getSourcePackageName", "()Ljava/lang/String;", "getSourceAppName", "getSourceBitmap", "()Landroid/graphics/Bitmap;", "getSourceBitmapFileEntity", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "getSourceActivity", "()Landroid/content/ComponentName;", "getFixedIntent", "getPageContextCaptureDisabled", "()Z", "getChatHistory", "getRefMemoryEntities", "()Ljava/util/List;", "getSubIntent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRawChatHistory", "getSourceScreenshotTosKey", "getLogId", "getLogContext", "()Lcom/obric/memorydata/middleware/api/logging/LogContext;", "getEnableStream", "getPageContextHandle", "()Lcom/obric/memorydata/dc/PageContextHandle;", "getBuildControl", "()Lcom/obric/memorydata/memory/llm/MemoryBuildControl;", "getInAppAssociation", "()Lcom/obric/memorydata/memory/memoryentity/InAppMemoryAssociation;", "getSourceImageInfo", "()Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "getSourceBitmapUploadResizeFactor", "()F", "getCurrentTimeMillis", "()J", "sourceText", "getSourceText", "sourceQuery", "getSourceQuery", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(ILjava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;Ljava/lang/String;Landroid/content/ComponentName;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/logging/LogContext;ZLcom/obric/memorydata/dc/PageContextHandle;Lcom/obric/memorydata/memory/llm/MemoryBuildControl;Lcom/obric/memorydata/memory/memoryentity/InAppMemoryAssociation;Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;FJ)Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "equals", "other", "hashCode", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10324b;
    private final String c;
    private final Bitmap d;
    private final String e;
    private final FileEntity f;
    private final String g;
    private final ComponentName h;
    private final String i;
    private final boolean j;
    private final String k;
    private final List<MemoryEntity> l;
    private final Integer m;
    private final String n;
    private final String o;
    private final String p;
    private final com.obric.memorydata.middleware.api.logging.e q;
    private final boolean r;
    private final com.obric.memorydata.dc.a s;
    private final com.obric.memorydata.memory.llm.c t;
    private final b u;
    private final e v;
    private final float w;
    private final long x;

    public f(int r8, String r9, String r10, Bitmap r11, String r12, FileEntity r13, String r14, ComponentName r15, String r16, boolean r17, String r18, List<? extends MemoryEntity> r19, Integer r20, String r21, String r22, String r23, com.obric.memorydata.middleware.api.logging.e r24, boolean r25, com.obric.memorydata.dc.a r26, com.obric.memorydata.memory.llm.c r27, b r28, e r29, float r30, long r31) {
        List<MemoryEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "sourcePackageName");
        Intrinsics.checkNotNullParameter(r10, "sourceAppName");
        Intrinsics.checkNotNullParameter(r24, "logContext");
        this.f10323a = r8;
        this.f10324b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r4;
        this.m = r20;
        this.n = r21;
        this.o = r22;
        this.p = r23;
        this.q = r24;
        this.r = r25;
        this.s = r26;
        this.t = r27;
        this.u = r28;
        this.v = r29;
        this.w = r30;
        this.x = r31;
    }

    public /* synthetic */ f(int r31, String r32, String r33, Bitmap r34, String r35, FileEntity r36, String r37, ComponentName r38, String r39, boolean r40, String r41, List r42, Integer r43, String r44, String r45, String r46, com.obric.memorydata.middleware.api.logging.e r47, boolean r48, com.obric.memorydata.dc.a r49, com.obric.memorydata.memory.llm.c r50, b r51, e r52, float r53, long r54, int r56, DefaultConstructorMarker r57) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.memorydata.plugin");
        if ((r56 & 128) == 0) goto L5;
        ComponentName r12 = null;
    L7:
        if ((r56 & 256) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r56 & 512) == 0) goto L13;
        boolean r14 = false;
    L15:
        if ((r56 & 1024) == 0) goto L17;
        String r15 = null;
    L19:
        if ((r56 & 2048) == 0) goto L21;
        List r16 = null;
    L23:
        if ((r56 & 4096) == 0) goto L25;
        Integer r17 = 0;
    L27:
        if ((r56 & 8192) == 0) goto L29;
        String r18 = null;
    L31:
        if ((r56 & 16384) == 0) goto L33;
        String r19 = null;
    L35:
        if ((32768 & r56) == 0) goto L37;
        String r20 = null;
    L39:
        if ((65536 & r56) == 0) goto L41;
        com.obric.memorydata.middleware.api.logging.e r21 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
    L43:
        if ((131072 & r56) == 0) goto L45;
        boolean r22 = false;
    L47:
        if ((262144 & r56) == 0) goto L49;
        com.obric.memorydata.dc.a r23 = null;
    L51:
        if ((524288 & r56) == 0) goto L53;
        com.obric.memorydata.memory.llm.c r24 = null;
    L55:
        if ((1048576 & r56) == 0) goto L57;
        b r25 = null;
    L59:
        if ((2097152 & r56) == 0) goto L61;
        e r26 = null;
    L63:
        if ((4194304 & r56) == 0) goto L65;
        float r27 = 0.5f;
    L67:
        if ((r56 & 8388608) == 0) goto L69;
        long r28 = System.currentTimeMillis();
    L70:
        this(r31, r32, r33, r34, r35, r36, r37, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        return;
    L69:
        r28 = r54;
        goto L70
    L65:
        r27 = r53;
        goto L67
    L61:
        r26 = r52;
        goto L63
    L57:
        r25 = r51;
        goto L59
    L53:
        r24 = r50;
        goto L55
    L49:
        r23 = r49;
        goto L51
    L45:
        r22 = r48;
        goto L47
    L41:
        r21 = r47;
        goto L43
    L37:
        r20 = r46;
        goto L39
    L33:
        r19 = r45;
        goto L35
    L29:
        r18 = r44;
        goto L31
    L25:
        r17 = r43;
        goto L27
    L21:
        r16 = r1;
        goto L23
    L17:
        r15 = r41;
        goto L19
    L13:
        r14 = r40;
        goto L15
    L9:
        r13 = r39;
        goto L11
    L5:
        r12 = r38;
        goto L7
    }

    public final int a() {
        return this.f10323a;
    }

    public final String b() {
        return this.f10324b;
    }

    public final String c() {
        return this.c;
    }

    public final Bitmap d() {
        return this.d;
    }

    public final FileEntity e() {
        return this.f;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, f.class) == true) goto L8;
        return false;
    L8:
        f r8 = (f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.memorydata.plugin");
        if (this.f10323a == r8.f10323a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10324b, r8.f10324b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r8.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r8.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r8.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r8.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r8.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r8.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r8.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r8.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r8.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r8.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r8.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r8.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r8.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r8.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r8.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r8.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r8.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r8.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r8.v) == true) goto L75;
        return false;
    L75:
        if (Float.compare(this.w, r8.w) == 0) goto L78;
        return false;
    L78:
        if (this.x == r8.x) goto L80;
        return false;
    L80:
        return true;
    }

    public final ComponentName f() {
        return this.h;
    }

    public final boolean g() {
        return this.j;
    }

    public final String h() {
        return this.k;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.f10323a) * 31) + this.f10324b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Bitmap r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        FileEntity r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ComponentName r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((r16 + r18) * 31) + Boolean.hashCode(this.j)) * 31;
        String r20 = this.k;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        List<MemoryEntity> r23 = this.l;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Integer r26 = this.m;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.n;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.o;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        String r35 = this.p;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (((((r34 + r36) * 31) + this.q.hashCode()) * 31) + Boolean.hashCode(this.r)) * 31;
        com.obric.memorydata.dc.a r38 = this.s;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        com.obric.memorydata.memory.llm.c r41 = this.t;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        b r44 = this.u;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        e r47 = this.v;
        if (r47 == null) goto L67;
        r2 = r47.hashCode();
    L67:
        return ((((r46 + r2) * 31) + Float.hashCode(this.w)) * 31) + Long.hashCode(this.x);
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final List<MemoryEntity> i() {
        return this.l;
    }

    public final Integer j() {
        return this.m;
    }

    public final String k() {
        return this.n;
    }

    public final String l() {
        return this.o;
    }

    public final String m() {
        return this.p;
    }

    public final com.obric.memorydata.middleware.api.logging.e n() {
        return this.q;
    }

    public final boolean o() {
        return this.r;
    }

    public final com.obric.memorydata.dc.a p() {
        return this.s;
    }

    public final com.obric.memorydata.memory.llm.c q() {
        return this.t;
    }

    public final b r() {
        return this.u;
    }

    public final e s() {
        return this.v;
    }

    public final float t() {
        return this.w;
    }

    public String toString() {
        return "MemorySourceInfo(productType=" + this.f10323a + ", sourcePackageName='" + this.f10324b + "', sourceAppName='" + this.c + "', sourceActivity=" + this.h + ", sourceBitmap=" + this.d + ", sourceBitmapFileEntity=" + this.f + ", )";
    }

    public final long u() {
        return this.x;
    }

    public final String v() {
        String r1 = this.e;
        if (r1 != null) goto L7;
        return null;
    L7:
        return StringsKt.take(r1, 2000);
    }

    public final String w() {
        String r1 = this.g;
        if (r1 != null) goto L7;
        return null;
    L7:
        return StringsKt.take(r1, 2000);
    }
}
