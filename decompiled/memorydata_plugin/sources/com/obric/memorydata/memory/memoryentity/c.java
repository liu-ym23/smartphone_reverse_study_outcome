package com.obric.memorydata.memory.memoryentity;

import android.content.Intent;
import android.graphics.Bitmap;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.dc.PageContextData;
import com.obric.memorydata.dc.PageContextResult;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.s;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001CB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eJ^\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u0016\u001a\u00020\u0017*\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005JJ\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J¢\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010)\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010+\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010-\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u00100\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u00101\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u00102\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u00103\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u00104\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u00106\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J&\u00107\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J!\u00108\u001a\u0002092\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050;\"\u00020\u0005H\u0002¢\u0006\u0002\u0010<J\u001a\u0010=\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010A2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/MemoryEntityConstructor;", "", "<init>", "()V", "TAG", "", "generateMemoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memoryJson", "Lorg/json/JSONObject;", "memorySourceInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "entityIdForEvaluate", "detailStatus", "", "generateAssistantChatMemoryEntity", "type", SlardarSettingsConstants.PERF_KEY_MEMORY, "sourceText", "logId", "sourceQuery", MemoryListActivity.JUMP_FROM_DETAIL, "enhanceByPageContext", "", "result", "Lcom/obric/memorydata/dc/PageContextResult;", ObricMemoryConstants.KEY_PACKAGE_NAME, "generateMemoryEntityReal", "adjustSource", "Lcom/obric/memorydata/memory/memoryentity/MemoryEntityConstructor$SourceInfoAdjusted;", "construct", "productType", "memoryType", "sourceBitmap", "Landroid/graphics/Bitmap;", "sourcePackageName", "sourceAppName", "sourceBitMapFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "sourceImageInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "constructOrderFlightMemoryEntity", "constructOrderTrainMemoryEntity", "constructOrderHotelMemoryEntity", "constructOrderTicketMemoryEntity", "constructOrderCommonMemoryEntity", "constructInfoDocumentsMemoryEntity", "constructInfoAddressMemoryEntity", "constructInfoAnniversaryMemoryEntity", "constructInfoRelationshipMemoryEntity", "constructInfoCommonMemoryEntity", "constructCollectContentMemoryEntity", "constructCollectStoreMemoryEntity", "constructEventScheduleMemoryEntity", "constructEventTodoMemoryEntity", "constructCommonTextMemoryEntity", "areAllStringsNotEmpty", "", "strings", "", "([Ljava/lang/String;)Z", "getStringFromJson", "json", "key", "getListStringFromJson", "", "typeToEntityType", "SourceInfoAdjusted", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10314a = null;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/MemoryEntityConstructor$SourceInfoAdjusted;", "", "sourceText", "", "sourceBitmap", "Landroid/graphics/Bitmap;", "sourceBitmapFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "sourceImageInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "sourcePackageName", "sourceAppName", "<init>", "(Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/obric/capabilitykit/entity/app/FileEntity;Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;Ljava/lang/String;Ljava/lang/String;)V", "getSourceText", "()Ljava/lang/String;", "getSourceBitmap", "()Landroid/graphics/Bitmap;", "getSourceBitmapFileEntity", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "getSourceImageInfo", "()Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "getSourcePackageName", "getSourceAppName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bitmap f10316b;
        private final FileEntity c;
        private final e d;
        private final String e;
        private final String f;

        public a(String r1, Bitmap r2, FileEntity r3, e r4, String r5, String r6) {
            this.f10315a = r1;
            this.f10316b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final String a() {
            return this.f10315a;
        }

        public final Bitmap b() {
            return this.f10316b;
        }

        public final FileEntity c() {
            return this.c;
        }

        public final e d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10315a, r6.f10315a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10316b, r6.f10316b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final String f() {
            return this.f;
        }

        public int hashCode() {
            String r0 = this.f10315a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Bitmap r4 = this.f10316b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            FileEntity r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            e r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
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

        public String toString() {
            return "SourceInfoAdjusted(sourceText=" + this.f10315a + ", sourceBitmap=" + this.f10316b + ", sourceBitmapFileEntity=" + this.c + ", sourceImageInfo=" + this.d + ", sourcePackageName=" + this.e + ", sourceAppName=" + this.f + ')';
        }
    }

    static {
        f10314a = new c();
    }

    private c() {
    }

    private final MemoryEntity a(int r16, String r17, JSONObject r18, String r19, String r20, Bitmap r21, String r22, String r23, String r24, FileEntity r25, e r26, String r27, String r28, int r29) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "construct memoryEntity, type: " + r17 + ", productType: " + r16, false, 4, null);
        switch(r17.hashCode()) {
            case -1271823248: goto L62;
            case -940675184: goto L58;
            case -873960692: goto L54;
            case -732377866: goto L50;
            case -505296440: goto L46;
            case -261851592: goto L42;
            case 3355: goto L38;
            case 3552645: goto L34;
            case 96891546: goto L30;
            case 99467700: goto L26;
            case 106006350: goto L22;
            case 110621192: goto L18;
            case 951530617: goto L14;
            case 1484547493: goto L10;
            case 1493127584: goto L6;
            default: goto L65;
        };
    L65:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "memoryJson type is error: " + r17, null, 4, null);
        MemoryEntity r0 = null;
    L66:
        if (r0 == null) goto L75;
        r0.setProductType(r16);
        r0.setSourceText(r20);
        if (r25 != null) goto L72;
        if (r21 == null) goto L71;
        FileEntity r1 = (FileEntity) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryEntityConstructor$construct$1$1(r21, r26, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), FileEntity.class, "com.obric.memorydata.plugin");
    L73:
        r0.setScreenshot(r1);
        r0.setSourcePackageName(r22);
        r0.setSourceAppName(r23);
        r0.setLogId(r24);
        r0.setSourceQuery(r27);
        r0.setDetail(r28);
        r0.setDetailStatus(r29);
        return r0;
    L71:
        r1 = null;
        goto L73
    L72:
        r1 = r25;
        goto L73
    L75:
        return null;
    L6:
        if (r17.equals("common_address") == false) goto L65;
        r0 = g(r16, r18, r19);
        goto L66
    L10:
        if (r17.equals("general_info") == false) goto L65;
        r0 = j(r16, r18, r19);
        goto L66
    L14:
        if (r17.equals(Params.CONTENT) == false) goto L65;
        r0 = o(r16, r18, r19);
        goto L66
    L18:
        if (r17.equals("train") == false) goto L65;
        r0 = b(r16, r18, r19);
        goto L66
    L22:
        if (r17.equals("order") == false) goto L65;
        r0 = e(r16, r18, r19);
        goto L66
    L26:
        if (r17.equals("hotel") == false) goto L65;
        r0 = c(r16, r18, r19);
        goto L66
    L30:
        if (r17.equals("event") == false) goto L65;
        r0 = m(r16, r18, r19);
        goto L66
    L34:
        if (r17.equals("task") == false) goto L65;
        r0 = n(r16, r18, r19);
        goto L66
    L38:
        if (r17.equals(OaidModel.KEY_ID) == false) goto L65;
        r0 = f(r16, r18, r19);
        goto L66
    L42:
        if (r17.equals("relationship") == false) goto L65;
        r0 = i(r16, r18, r19);
        goto L66
    L46:
        if (r17.equals("merchant") == false) goto L65;
        r0 = l(r16, r18, r19);
        goto L66
    L50:
        if (r17.equals("article") == false) goto L65;
        r0 = k(r16, r18, r19);
        goto L66
    L54:
        if (r17.equals(Api.KEY_TICKET) == false) goto L65;
        r0 = d(r16, r18, r19);
        goto L66
    L58:
        if (r17.equals("anniversary") == false) goto L65;
        r0 = h(r16, r18, r19);
        goto L66
    L62:
        if (r17.equals("flight") == false) goto L65;
        r0 = a(r16, r18, r19);
        goto L66
    }

    private final MemoryEntity a(int r23, JSONObject r24, String r25) {
        String r10 = r24.optString("departure_date");
        String r11 = r24.optString("departure_city");
        String r12 = r24.optString("arrival_city");
        String r13 = r24.optString("departure_time");
        String r14 = r24.optString("arrival_time");
        String r15 = r24.optString("flight_number");
        if (a(new String[]{r10, r11, r12, r13, r14, r15}) == false) goto L10;
        long r7 = System.currentTimeMillis();
        if (r25 != null) goto L7;
        String r4 = "10001_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r15);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new OrderFlightMemoryEntity(r4, r7, r7, r23, r10, r11, r12, r13, r14, r15, b(r24, "arrival_date"), b(r24, "departure_airport"), b(r24, "arrival_airport"), b(r24, "gate"), a(r24, "passenger"), a(r24, "seat")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r25;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructOrderFlightMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    static /* synthetic */ MemoryEntity a(c r18, int r19, String r20, JSONObject r21, String r22, String r23, Bitmap r24, String r25, String r26, String r27, FileEntity r28, e r29, String r30, String r31, int r32, int r33, Object r34) {
        if ((r33 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r33 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r33 & 32) == 0) goto L13;
        Bitmap r9 = null;
    L15:
        if ((r33 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r33 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r33 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r33 & 512) == 0) goto L29;
        FileEntity r13 = null;
    L31:
        if ((r33 & 1024) == 0) goto L33;
        e r14 = null;
    L35:
        if ((r33 & 2048) == 0) goto L37;
        String r15 = null;
    L39:
        if ((r33 & 4096) == 0) goto L41;
        String r16 = null;
    L43:
        return r18.a(r19, r20, r21, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r32);
    L41:
        r16 = r31;
        goto L43
    L37:
        r15 = r30;
        goto L39
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r28;
        goto L31
    L25:
        r12 = r27;
        goto L27
    L21:
        r11 = r26;
        goto L23
    L17:
        r10 = r25;
        goto L19
    L13:
        r9 = r24;
        goto L15
    L9:
        r8 = r23;
        goto L11
    L5:
        r7 = r22;
        goto L7
    }

    public static /* synthetic */ MemoryEntity a(c r12, String r13, JSONObject r14, String r15, String r16, String r17, String r18, String r19, int r20, int r21, Object r22) {
        if ((r21 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r21 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r21 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r21 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r21 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r21 & 128) == 0) goto L25;
        int r11 = 0;
    L27:
        return r12.a(r13, r14, r6, r7, r8, r9, r10, r11);
    L25:
        r11 = r20;
        goto L27
    L21:
        r10 = r19;
        goto L23
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public static /* synthetic */ MemoryEntity a(c r0, JSONObject r1, f r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = 0;
    L9:
        return r0.a(r1, r2, r3, r4);
    }

    static /* synthetic */ MemoryEntity a(c r9, JSONObject r10, f r11, String r12, String r13, String r14, int r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        int r8 = 0;
    L19:
        return r9.a(r10, r11, r5, r6, r7, r8);
    L17:
        r8 = r15;
        goto L19
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    private final MemoryEntity a(JSONObject r19, f r20, String r21, String r22, String r23, int r24) {
        if (r19 != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "memoryJson is null", null, 4, null);
        return null;
    L6:
        int r3 = y.a(r19, "errorCode");
        if (r3 == 0) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "memoryJson is not ok: " + r3 + ", " + y.b(r19, DTraitConstant.ERROR), null, 4, null);
        return null;
    L10:
        JSONObject r6 = r19.optJSONObject("data");
        if (r6 != null) goto L13;
        return null;
    L13:
        a r4 = a(r6, r20);
        int r5 = r20.a();
        String r7 = r19.optString("type");
        Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");
        String r8 = r4.a();
        Bitmap r9 = r4.b();
        String r10 = r4.e();
        String r11 = r4.f();
        if (r22 != null) goto L16;
        String r12 = r19.optString("logId");
    L18:
        return a(r5, r7, r6, r21, r8, r9, r10, r11, r12, r4.c(), r4.d(), r20.w(), r23, r24);
    L16:
        r12 = r22;
        goto L18
    }

    private final a a(JSONObject r18, f r19) {
        String r0 = r18.optString(AILabCheckPermissionTask.KEY_SOURCE);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "adjustSource, from: " + r0, false, 4, null);
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L51;
        String r4 = "screenshot";
        if (Intrinsics.areEqual(r0, "screenshot") == true) goto L51;
        if (Intrinsics.areEqual(r0, "screen_content") == true) goto L51;
        String r5 = r19.h();
        if (Intrinsics.areEqual(r0, "user_query") == false) goto L36;
        com.obric.memorydata.memory.memoryentity.a r6 = com.obric.memorydata.memory.memoryentity.a.f10308a;
        String r7 = r19.h();
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        List<ChatMessage> r8 = r6.a(r7);
        if (r8.size() > 1) goto L23;
        boolean r9 = true;
    L25:
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L36;
        ChatMessage r10 = (ChatMessage) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r8), ChatMessage.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10.getRoleType(), "user") == true) goto L29;
    L31:
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("query has been rewrote, rewrote by ");
        if (r9 == true) goto L35;
        r4 = "chat history";
    L35:
        IRunLog.a.a(r11, "MemoryEntityConstructor", r12.append(r4).toString(), false, 4, null);
        String r13 = r5;
        r2 = r9;
    L38:
        if (r2 == false) goto L40;
        String r14 = r19.b();
    L41:
        String r15 = r14;
        String r16 = null;
        if (r2 == false) goto L45;
        r16 = r19.c();
    L49:
        return new a(r13, null, null, null, r15, r16);
    L45:
        com.obric.memorydata.utils.c.a r17 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, AppInfo.OAssistant.getPackageName(), null, 2, null);
        if (r17 == null) goto L49;
        r16 = r17.a();
        goto L49
    L40:
        r14 = AppInfo.OAssistant.getPackageName();
        goto L41
    L29:
        if (Intrinsics.areEqual(r10.getContent(), r19.w()) == false) goto L31;
        r5 = com.obric.memorydata.memory.memoryentity.a.f10308a.a(CollectionsKt.listOf(r10));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "simplify chat history to raw query", false, 4, null);
        goto L36
    L23:
        r9 = false;
    L36:
        r13 = r5;
    L51:
        if (r19.w() == null) goto L53;
        String r20 = r19.h();
    L55:
        return new a(r20, r19.d(), r19.e(), r19.s(), r19.b(), r19.c());
    L53:
        r20 = r19.v();
        goto L55
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final boolean a(String... r7) {
        int r6 = r7.length;
        int r1 = 0;
    L3:
        boolean r2 = true;
        if (r1 >= r6) goto L13;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7[r1], CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L16;
        r1 = r1 + 1;
        goto L3
    L16:
        return false;
    L13:
        return true;
    }

    private final MemoryEntity b(int r23, JSONObject r24, String r25) {
        String r10 = r24.optString("departure_date");
        String r11 = r24.optString("departure_city");
        String r12 = r24.optString("arrival_city");
        String r13 = r24.optString("departure_time");
        String r14 = r24.optString("arrival_time");
        String r15 = r24.optString("train_number");
        if (a(new String[]{r10, r11, r12, r13, r14, r15}) == false) goto L10;
        long r7 = System.currentTimeMillis();
        if (r25 != null) goto L7;
        String r4 = "10002_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r15);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new OrderTrainMemoryEntity(r4, r7, r7, r23, r10, r11, r12, r13, r14, r15, b(r24, "arrival_date"), b(r24, "departure_station"), b(r24, "arrival_station"), b(r24, "gate"), a(r24, "passenger"), a(r24, "seat")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r25;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructOrderTrainMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final String b(JSONObject r2, String r3) {
        Object r1 = r2.opt(r3);
        CharSequence r4 = null;
        if (Intrinsics.areEqual(r1, JSONObject.NULL) == false) goto L5;
    L16:
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L16;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5.length() != 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L15;
        r4 = r5;
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L10:
        r6 = false;
        goto L11
    }

    private final MemoryEntity c(int r18, JSONObject r19, String r20) {
        String r10 = r19.optString("checkin_date");
        String r11 = r19.optString("hotel_name");
        if (a(new String[]{r10, r11}) == false) goto L10;
        long r7 = System.currentTimeMillis();
        if (r20 != null) goto L7;
        String r4 = "10004_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new OrderHotelMemoryEntity(r4, r7, r7, r18, r10, r11, b(r19, "checkout_date"), b(r19, "hotel_address"), b(r19, "checkin_time"), b(r19, "checkout_time"), b(r19, "city")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r20;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructOrderHotelMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity d(int r20, JSONObject r21, String r22) {
        String r10 = r21.optString("title");
        String r11 = r21.optString("date");
        String r12 = r21.optString("start_time");
        if (a(new String[]{r10, r11, r12}) == false) goto L10;
        long r7 = System.currentTimeMillis();
        if (r22 != null) goto L7;
        String r4 = "10006_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r12);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new OrderTicketMemoryEntity(r4, r7, r7, r20, r10, r11, r12, b(r21, "end_time"), b(r21, "city"), b(r21, "location"), b(r21, MemoryKeyInfoEntity.KEY_ADDRESS), b(r21, "hall_number"), a(r21, "seat")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r22;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructOrderTicketMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity e(int r16, JSONObject r17, String r18) {
        String r10 = r17.optString(ActivityLifecycle.NAME);
        if (a(new String[]{r10}) == false) goto L10;
        long r7 = System.currentTimeMillis();
        if (r18 != null) goto L7;
        String r4 = "10005_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new OrderCommonMemoryEntity(r4, r7, r7, r16, r10, b(r17, "description"), b(r17, "created_date"), b(r17, "created_time")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r18;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructOrderCommonMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity f(int r13, JSONObject r14, String r15) {
        String r8 = r14.optString("id_type");
        String r9 = r14.optString("id_number");
        if (a(new String[]{r8, r9}) == false) goto L9;
        long r5 = System.currentTimeMillis();
        if (r15 != null) goto L7;
        r15 = "10101_" + r5;
    L7:
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r9);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new InfoDocumentsMemoryEntity(r15, r5, r5, r13, r8, r9, b(r14, "full_name")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructInfoDocumentsMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity g(int r11, JSONObject r12, String r13) {
        String r8 = r12.optString("type");
        String r9 = r12.optString("details");
        if (a(new String[]{r8, r9}) == false) goto L9;
        long r5 = System.currentTimeMillis();
        if (r13 != null) goto L7;
        r13 = "10102_" + r5;
    L7:
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r9);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new InfoAddressMemoryEntity(r13, r5, r5, r11, r8, r9), MemoryEntity.class, "com.obric.memorydata.plugin");
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructInfoAddressMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity h(int r11, JSONObject r12, String r13) {
        String r8 = r12.optString("type");
        String r9 = r12.optString("date");
        if (a(new String[]{r8, r9}) == false) goto L9;
        long r5 = System.currentTimeMillis();
        if (r13 != null) goto L7;
        r13 = "10103_" + r5;
    L7:
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r9);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new InfoAnniversaryMemoryEntity(r13, r5, r5, r11, r8, r9), MemoryEntity.class, "com.obric.memorydata.plugin");
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructInfoAnniversaryMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity i(int r11, JSONObject r12, String r13) {
        String r8 = r12.optString("type");
        String r9 = r12.optString(ActivityLifecycle.NAME);
        if (a(new String[]{r8, r9}) == false) goto L9;
        long r5 = System.currentTimeMillis();
        if (r13 != null) goto L7;
        r13 = "10104_" + r5;
    L7:
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r9);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new InfoRelationshipMemoryEntity(r13, r5, r5, r11, r8, r9), MemoryEntity.class, "com.obric.memorydata.plugin");
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructInfoRelationshipMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity j(int r17, JSONObject r18, String r19) {
        String r9 = r18.optString("key");
        String r10 = r18.optString(EventBody.KEY_VALUE);
        String r13 = r18.optString(LocationMonitorConst.TAG);
        if (a(new String[]{r9, r10}) == false) goto L10;
        long r6 = System.currentTimeMillis();
        if (r19 != null) goto L7;
        String r3 = "10105_" + r6;
    L8:
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNull(r10);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new InfoCommonMemoryEntity(r3, r6, r6, r17, r9, r10, null, null, r13, 192, null), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r3 = r19;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructInfoCommonMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity k(int r17, JSONObject r18, String r19) {
        String r10 = r18.optString("title");
        String r11 = r18.optString("abstract");
        if (a(new String[]{r10, r11}) == false) goto L10;
        long r7 = System.currentTimeMillis();
        if (r19 != null) goto L7;
        String r4 = "10201_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new CollectContentMemoryEntity(r4, r7, r7, r17, r10, r11, b(r18, "appName"), b(r18, ObricMemoryConstants.KEY_PACKAGE_NAME), a(r18, "tags")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r19;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructCollectContentMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity l(int r17, JSONObject r18, String r19) {
        String r10 = r18.optString(ActivityLifecycle.NAME);
        if (a(new String[]{r10}) == false) goto L10;
        long r7 = System.currentTimeMillis();
        if (r19 != null) goto L7;
        String r4 = "10202_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new CollectStoreMemoryEntity(r4, r7, r7, r17, r10, b(r18, "appName"), b(r18, ObricMemoryConstants.KEY_PACKAGE_NAME), b(r18, MemoryKeyInfoEntity.KEY_ADDRESS), b(r18, EventBody.KEY_CATEGORY), b(r18, "city")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r19;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructCollectStoreMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity m(int r17, JSONObject r18, String r19) {
        String r10 = r18.optString("title");
        String r11 = r18.optString("date");
        String r12 = r18.optString("start_time");
        String r2 = r18.optString("end_date");
        boolean r4 = false;
        CharSequence r6 = null;
        if (a(new String[]{r10, r11, r12}) == false) goto L16;
        long r7 = System.currentTimeMillis();
        if (r19 != null) goto L7;
        String r9 = "10301_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r12);
        String r13 = b(r18, "end_time");
        String r14 = b(r18, "location");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0.length() != 0) goto L11;
        r4 = true;
    L11:
        if (r4 == true) goto L15;
        r6 = r0;
    L15:
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new EventScheduleMemoryEntity(r9, r7, r7, r17, r10, r11, r12, r13, r14, (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r9 = r19;
        goto L8
    L16:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructEventScheduleMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity n(int r13, JSONObject r14, String r15) {
        String r8 = r14.optString("title");
        if (a(new String[]{r8}) == false) goto L9;
        long r5 = System.currentTimeMillis();
        if (r15 != null) goto L7;
        r15 = "10302_" + r5;
    L7:
        Intrinsics.checkNotNull(r8);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new EventTodoMemoryEntity(r15, r5, r5, r13, r8, b(r14, "due_date"), b(r14, "due_time")), MemoryEntity.class, "com.obric.memorydata.plugin");
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructEventTodoMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    private final MemoryEntity o(int r17, JSONObject r18, String r19) {
        String r10 = r18.optString("summary");
        String r12 = r18.optString("title");
        if (a(new String[]{r12}) == false) goto L10;
        long r7 = System.currentTimeMillis();
        if (r19 != null) goto L7;
        String r4 = "10401_" + r7;
    L8:
        Intrinsics.checkNotNull(r10);
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(new CommonTextMemoryEntity(r4, r7, r7, r17, r10, b(r18, "created_time"), r12, a(r18, "tags"), b(r18, EventBody.KEY_CATEGORY)), MemoryEntity.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r19;
        goto L8
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "constructCommonTextMemoryEntity missing required parameter", null, 4, null);
        return null;
    }

    public final MemoryEntity a(String r19, JSONObject r20, String r21, String r22, String r23, String r24, String r25, int r26) {
        Intrinsics.checkNotNullParameter(r19, "type");
        Intrinsics.checkNotNullParameter(r20, SlardarSettingsConstants.PERF_KEY_MEMORY);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "generateAssistantChatMemoryEntity begin", false, 4, null);
        String r8 = AppInfo.OAssistant.getPackageName();
        com.obric.memorydata.utils.c.a r0 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, AppInfo.OAssistant.getPackageName(), null, 2, null);
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L8:
        return a(this, 4, r19, r20, r21, r22, null, r8, r1, r23, null, null, r24, r25, r26, 1056, null);
    L6:
        r1 = AppInfo.OAssistant.getAppName();
        goto L8
    }

    public final MemoryEntity a(JSONObject r11, f r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "memorySourceInfo");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityConstructor", "generateMemoryEntity begin", false, 4, null);
        return a(this, r11, r12, r13, null, null, r14, 24, null);
    }

    public final List<String> a(JSONObject r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "json");
        Intrinsics.checkNotNullParameter(r5, "key");
        JSONArray r3 = r4.optJSONArray(r5);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.length() == 0) goto L14;
        List<String> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r7 = 0;
        int r0 = r3.length();
    L8:
        if (r7 >= r0) goto L10;
        String r1 = r3.optString(r7);
        Intrinsics.checkNotNullExpressionValue(r1, "optString(...)");
        r6.add(r1);
        r7 = r7 + 1;
        goto L8
    L10:
        return r6;
    L14:
        return null;
    }

    public final void a(MemoryEntity r3, PageContextResult r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "result");
        if (ZeusTransformUtils.instanceOf(r3, CollectContentMemoryEntity.class) == false) goto L5;
    L8:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.getSourceLink(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L44;
        PageContextData r7 = r4.getData();
        String r0 = null;
        if (r7 == null) goto L19;
        String r8 = r7.getDeeplink();
    L21:
        if (at.a(r8) == false) goto L26;
        r3.setSourceLinkType(MemorySourceLinkType.DEEPLINK);
        PageContextData r9 = r4.getData();
        if (r9 == null) goto L25;
        r0 = r9.getDeeplink();
    L25:
        r3.setSourceLink(r0);
        goto L44
    L26:
        PageContextData r10 = r4.getData();
        if (r10 == null) goto L29;
        String r11 = r10.getUrl();
    L31:
        if (at.a(r11) == false) goto L36;
        r3.setSourceLinkType("url");
        PageContextData r12 = r4.getData();
        if (r12 == null) goto L25;
        r0 = r12.getUrl();
        goto L25
    L36:
        if (r4.getIntent() == null) goto L44;
        s r13 = s.f10512a;
        Intent r1 = r4.getIntent();
        Intrinsics.checkNotNull(r1);
        if (r5 != null) goto L40;
        r5 = "";
    L40:
        String r14 = r13.a(r1, r5);
        if (r14 == null) goto L44;
        r3.setSourceLink(r14);
        r3.setSourceLinkType(MemorySourceLinkType.INTENT);
        goto L44
    L29:
        r11 = null;
        goto L31
    L19:
        r8 = null;
    L44:
        if (ZeusTransformUtils.instanceOf(r3, CollectContentMemoryEntity.class) == false) goto L52;
        PageContextData r15 = r4.getData();
        if (r15 == null) goto L53;
        String r16 = r15.getTitle();
        if (r16 == null) goto L54;
        ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r3, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).setTitle(r16);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r6 = false;
        goto L15
    L5:
        if (ZeusTransformUtils.instanceOf(r3, CollectStoreMemoryEntity.class) == true) goto L8;
        if (ZeusTransformUtils.instanceOf(r3, CommonTextMemoryEntity.class) == true) goto L8;
    }
}
