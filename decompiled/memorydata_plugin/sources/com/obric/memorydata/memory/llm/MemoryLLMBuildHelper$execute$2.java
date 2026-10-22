package com.obric.memorydata.memory.llm;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.dc.PageContextData;
import com.obric.memorydata.dc.PageContextResult;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.union.build.s;
import com.obric.memorydata.utils.at;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0001*\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.MemoryLLMBuildHelper$execute$2", f = "MemoryLLMBuildHelper.kt", i = {}, l = {TypedValues.MotionType.TYPE_POLAR_RELATIVETO}, m = "invokeSuspend", n = {}, s = {})
final class MemoryLLMBuildHelper$execute$2 extends SuspendLambda implements Function2<al, Continuation<? super Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>>, Object> {
    final /* synthetic */ Map<String, Object> $extraMap;
    final /* synthetic */ e $inputData;
    final /* synthetic */ boolean $isDebug;
    final /* synthetic */ com.obric.memorydata.memory.memoryentity.f $memorySourceInfo;
    final /* synthetic */ PageContextResult $pageContextResult;
    final /* synthetic */ MemoryEntity $retryEntity;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ com.obric.memorydata.memory.tracker.d.b $trackingEvent;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class a implements Function1<JSONObject, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f10250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.memoryentity.f f10251b;
        final /* synthetic */ boolean c;
        final /* synthetic */ n<Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> d;
        final /* synthetic */ String e;
        final /* synthetic */ long f;
        final /* synthetic */ MemoryEntity g;
        final /* synthetic */ PageContextResult h;
        final /* synthetic */ Ref.ObjectRef<AbsTaskRequest> i;

        a(Map<String, Object> r3, com.obric.memorydata.memory.memoryentity.f r4, boolean r5, n<? super Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r6, String r7, long r8, MemoryEntity r10, PageContextResult r11, Ref.ObjectRef<AbsTaskRequest> r12) {
            Map<String, Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            n<Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r13 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.memorydata.plugin");
            this.f10250a = r9;
            this.f10251b = r4;
            this.c = r5;
            this.d = r13;
            this.e = r7;
            this.f = r8;
            this.g = r10;
            this.h = r11;
            this.i = r12;
        }

        public final void a(JSONObject r32) {
            Intrinsics.checkNotNullParameter(r32, "json");
            RunLog.INSTANCE.debug("MemoryLLMBuildHelper", "executeMemoryBuildByLLM progress: " + r32);
            String r2 = r32.optString("stage");
            if (r2 == null) goto L203;
            String r8 = "";
            switch(r2.hashCode()) {
                case -1274442605: goto L161;
                case -1077756671: goto L106;
                case -891990144: goto L102;
                case 3415681: goto L28;
                case 503000675: goto L8;
                default: goto L212;
            };
        L212:
            return;
        L8:
            if (r2.equals("interrupt") == false) goto L213;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM interrupt: " + r32, null, 4, null);
            JSONObject r1 = r32.optJSONObject(Params.CONTENT);
            if (r1 == null) goto L13;
            Integer r3 = Integer.valueOf(r1.optInt("errorCode"));
        L14:
            if (r1 == null) goto L16;
            String r10 = r1.optString(DTraitConstant.ERROR);
        L17:
            Map<String, Object> r4 = this.f10250a;
            if (r3 == null) goto L20;
            int r17 = r3.intValue();
        L21:
            r4.put("errorCode", Integer.valueOf(r17));
            Map<String, Object> r5 = this.f10250a;
            if (r10 != null) goto L24;
            r10 = "interrupt but no error msg";
        L24:
            r5.put(DTraitConstant.ERROR, r10);
            d.a(d.f10280a, this.e, 4, null, null, null, 28, null);
            AbsTaskRequest r0 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(this.i.element, AbsTaskRequest.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L204;
            r0.cancel();
            return;
        L204:
            return;
        L20:
            r17 = -1000;
            goto L21
        L16:
            r10 = null;
            goto L17
        L13:
            r3 = null;
            goto L14
        L213:
            return;
        L28:
            if (r2.equals("once") == false) goto L214;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM once", false, 4, null);
            JSONObject r6 = r32.optJSONObject(Params.CONTENT);
            if (r6 == null) goto L33;
            JSONObject r7 = r6.optJSONObject("extras");
        L34:
            if (r6 == null) goto L39;
            String r9 = r6.optString("logId");
            if (r9 == null) goto L39;
            r8 = r9;
        L39:
            this.f10250a.put("logId", r8);
            if (r6 == null) goto L42;
            JSONObject r11 = r6.optJSONObject("data");
        L43:
            if (r11 == null) goto L49;
            JSONArray r12 = r11.optJSONArray("modified_ids");
            if (r12 == null) goto L49;
            List r13 = d.a(d.f10280a, r12);
            if (r13 == null) goto L49;
            this.f10250a.put("modifiedIds", r13);
        L50:
            if (r13 == null) goto L52;
            String r14 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r13), String.class, "com.obric.memorydata.plugin");
        L54:
            if (at.a(r14) == false) goto L56;
            com.obric.memorydata.memory.utils.f r15 = com.obric.memorydata.memory.utils.f.f11537a;
            Intrinsics.checkNotNull(r14);
            MemoryEntity r16 = r15.a(r14, Integer.valueOf(EntityType.MEMORY_INFO_COMMON));
        L57:
            Map<String, Object> r18 = this.f10250a;
            if (r16 == null) goto L60;
            int r19 = 1;
        L61:
            r18.put("action", Integer.valueOf(r19));
            com.obric.memorydata.memory.memoryentity.c r24 = com.obric.memorydata.memory.memoryentity.c.f10314a;
            com.obric.memorydata.memory.memoryentity.f r110 = this.f10251b;
            Intrinsics.checkNotNull(r110);
            MemoryEntity r20 = com.obric.memorydata.memory.memoryentity.c.a(r24, r6, r110, null, 0, 12, null);
            if (this.c == false) goto L65;
            this.d.a(TuplesKt.to(r20, this.f10250a), null);
            return;
        L65:
            if (r20 == null) goto L79;
            r20.setUserEdit(true);
            if (r16 == null) goto L72;
            FileEntity r21 = r16.getScreenshot();
            if (r21 == null) goto L71;
            com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r21);
        L71:
            com.obric.memorydata.memory.calendar.b.f10085a.b(r16.getUuid());
            r20 = MemoryEntityManager.INSTANCE.updateIndex(r16, r20, MemoryEventTracker.GenerateMethod.UPDATE_QUERY);
        L78:
            k r22 = k.f10296a;
            String r23 = this.e;
            Intrinsics.checkNotNull(r20);
            r22.a(r23, r20);
            d.a(d.f10280a, r7, this.f10250a);
            k.f10296a.a(this.e);
            s.f13110a.a();
            RunLog.INSTANCE.debug("MemoryLLMBuildHelper", "memory cost: " + (System.currentTimeMillis() - this.f) + " ms");
        L81:
            if (this.d.a() == false) goto L83;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM RESUME newMemoryEntity", false, 4, null);
            this.d.a(TuplesKt.to(r20, this.f10250a), null);
        L83:
            if (r13 == null) goto L91;
            Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
            Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r27 = r25.iterator();
        L86:
            if (r27.hasNext() == false) goto L90;
            Object r28 = r27.next();
            if ((!Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r28, String.class, "com.obric.memorydata.plugin"), r14)) == false) goto L86;
            r26.add(r28);
            goto L86
        L90:
            List r111 = (List) ZeusTransformUtils.preCheckCast(r26, List.class, "com.obric.memorydata.plugin");
        L92:
            Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.memorydata.plugin");
            if (r29 != null) goto L95;
        L98:
            boolean r112 = true;
        L99:
            if (r112 == true) goto L206;
            IEntityManager r113 = (IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin");
            String r30 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
            Intrinsics.checkNotNullExpressionValue(r30, "getPackageName(...)");
            IEntityManager.a.a(r113, r111, NetError.ERR_CACHE_READ_FAILURE, r30, null, 8, null);
            RunLog.INSTANCE.debug("MemoryLLMBuildHelper", "executeMemoryBuildByLLM delete modifiedIds: " + r111);
            return;
        L206:
            return;
        L95:
            if (r29.isEmpty() == true) goto L98;
            r112 = false;
            goto L99
        L91:
            r111 = null;
            goto L92
        L72:
            MemoryEntity r31 = MemoryEntityManager.INSTANCE.index(r20);
            if (r31 == null) goto L78;
            FileEntity r33 = r31.getScreenshot();
            if (r33 == null) goto L77;
            com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r33);
        L77:
            com.obric.memorydata.memory.calendar.b.f10085a.b(r31.getUuid());
            goto L78
        L79:
            this.f10250a.put("errorCode", -1000);
            this.f10250a.put(DTraitConstant.ERROR, "gen memory entity failed");
            goto L81
        L60:
            r19 = 0;
            goto L61
        L56:
            r16 = null;
            goto L57
        L52:
            r14 = null;
        L49:
            r13 = null;
            goto L50
        L42:
            r11 = null;
            goto L43
        L33:
            r7 = null;
            goto L34
        L214:
            return;
        L102:
            if (r2.equals(CozeCloudExt.API_KEY_HTTP_STREAM_METHOD) == false) goto L215;
            k.a(k.f10296a, this.e, r32.optString(Params.CONTENT).toString(), null, 4, null);
            return;
        L215:
            return;
        L106:
            if (r2.equals(SlardarSettingsConstants.PERF_KEY_MEMORY) == false) goto L216;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM memory", false, 4, null);
            MemoryEntity r34 = this.g;
            if (r34 == null) goto L114;
            r34.setDetailStatus(1);
            k.f10296a.a(this.e, this.g);
            d.a(d.f10280a, this.e, 1, null, null, null, 28, null);
            if (this.d.a() == false) goto L209;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM RESUME retryEntity", false, 4, null);
            n<Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r35 = this.d;
            Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>> r36 = TuplesKt.to(this.g, this.f10250a);
        L113:
            r35.a(r36, null);
            return;
        L209:
            return;
        L114:
            JSONObject r37 = r32.optJSONObject(Params.CONTENT);
            if (r37 == null) goto L117;
            JSONObject r38 = r37.optJSONObject("extras");
        L118:
            if (r37 == null) goto L123;
            String r39 = r37.optString("logId");
            if (r39 == null) goto L123;
            r8 = r39;
        L123:
            com.obric.memorydata.memory.memoryentity.c r114 = com.obric.memorydata.memory.memoryentity.c.f10314a;
            com.obric.memorydata.memory.memoryentity.f r40 = this.f10251b;
            Intrinsics.checkNotNull(r40);
            MemoryEntity r41 = com.obric.memorydata.memory.memoryentity.c.a(r114, r37, r40, null, 1, 4, null);
            if (r41 != null) goto L126;
            this.f10250a.put("errorCode", -1000);
            this.f10250a.put(DTraitConstant.ERROR, "gen memory entity failed");
        L158:
            if (this.d.a() == false) goto L211;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM RESUME newMemoryEntity", false, 4, null);
            r35 = this.d;
            r36 = TuplesKt.to(r41, this.f10250a);
            goto L113
        L211:
            return;
        L126:
            if (this.h == null) goto L128;
            com.obric.memorydata.memory.memoryentity.c.f10314a.a(r41, this.h, this.f10251b.b());
        L128:
            RunLog r42 = RunLog.INSTANCE;
            StringBuilder r43 = new StringBuilder().append("enhanceByPageContext: entityTitle:");
            if (ZeusTransformUtils.instanceOf(r41, CommonTextMemoryEntity.class) == false) goto L131;
            CommonTextMemoryEntity r115 = (CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r41, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin");
        L132:
            if (r115 == null) goto L134;
            String r116 = r115.getTitle();
        L135:
            StringBuilder r44 = r43.append(r116).append(", pageTitle:");
            PageContextResult r117 = this.h;
            if (r117 == null) goto L140;
            PageContextData r118 = r117.getData();
            if (r118 == null) goto L140;
            String r119 = r118.getTitle();
        L141:
            r42.debug("PageContextManager", r44.append(r119).append(", sourceLinkType:").append(r41.getSourceLinkType()).append(", sourceLink:").append(r41.getSourceLink()).append(", ").toString());
            MemoryEntity r45 = MemoryEntityManager.INSTANCE.index(r41);
            if (r45 == null) goto L147;
            FileEntity r46 = r45.getScreenshot();
            if (r46 == null) goto L146;
            com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r46);
        L146:
            com.obric.memorydata.memory.calendar.b.f10085a.b(r45.getUuid());
        L147:
            k.f10296a.a(this.e, r41);
            List r47 = com.obric.memorydata.memory.calendar.c.a(com.obric.memorydata.memory.calendar.c.f10086a, r41, null, r37, 2, null);
            if (r47 != null) goto L150;
        L155:
            this.f10250a.put("logId", r8);
            d.a(d.f10280a, r38, this.f10250a);
            RunLog.INSTANCE.debug("MemoryLLMBuildHelper", "memory cost: " + (System.currentTimeMillis() - this.f) + " ms");
            goto L158
        L150:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r47, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L153;
            r47 = null;
        L153:
            if (r47 == null) goto L155;
            this.f10250a.put("schedules", r47);
        L140:
            r119 = null;
            goto L141
        L134:
            r116 = null;
            goto L135
        L131:
            r115 = null;
            goto L132
        L117:
            r38 = null;
            goto L118
        L216:
            return;
        L161:
            if (r2.equals("finish") == false) goto L217;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM finish", false, 4, null);
            JSONObject r48 = r32.optJSONObject(Params.CONTENT);
            Map r120 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            if (r48 == null) goto L180;
            List<String> r49 = com.obric.memorydata.memory.memoryentity.c.f10314a.a(r48, "tags");
            String r50 = r48.optString("summary");
            JSONArray r51 = r48.optJSONArray("entities");
            if (r51 == null) goto L179;
            int r52 = r51.length();
            int r53 = 0;
        L168:
            if (r53 >= r52) goto L179;
            JSONObject r54 = r51.optJSONObject(r53);
            if (r54 == null) goto L178;
            String r55 = r54.optString("key");
            if (r55 == null) goto L178;
            if (MemoryKeyInfoEntity.Companion.a().contains(r55) == false) goto L178;
            List<String> r56 = com.obric.memorydata.memory.memoryentity.c.f10314a.a(r54, EventBody.KEY_VALUE);
            if (r56 == null) goto L178;
            r120.put(r55, r56);
        L178:
            r53 = r53 + 1;
        L179:
            List<String> r57 = r49;
            String r58 = r50;
        L181:
            RunLog.INSTANCE.debug("MemoryLLMBuildHelper", "tags: " + r57 + ", summary: " + r58 + ", entities: " + r120);
            Iterator r59 = r120.entrySet().iterator();
        L183:
            if (r59.hasNext() == false) goto L188;
            Map.Entry r60 = (Map.Entry) ZeusTransformUtils.preCheckCast(r59.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Iterator r61 = ((Iterable) ZeusTransformUtils.preCheckCast(r60.getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L186:
            if (r61.hasNext() == false) goto L183;
            String r62 = (String) ZeusTransformUtils.preCheckCast(r61.next(), String.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.debug("MemoryLLMBuildHelper", "key: " + ((String) ZeusTransformUtils.preCheckCast(r60.getKey(), String.class, "com.obric.memorydata.plugin")) + ", value: " + r62 + ", contains \\n: " + StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r62, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null));
            goto L186
        L188:
            d.a(d.f10280a, this.e, 2, r58, r57, r120);
            return;
        L180:
            r58 = null;
            r57 = null;
            goto L181
        L217:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(JSONObject r3) {
            a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/llm/MemoryLLMBuildHelper$execute$2$1$3", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f10252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10253b;
        final /* synthetic */ com.obric.memorydata.memory.tracker.d.b c;
        final /* synthetic */ n<Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> d;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10254a = null;

            static {
                int[] r0 = new int[TaskInfo.State.values().length];
                r0[TaskInfo.State.TIMEOUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TaskInfo.State.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TaskInfo.State.CANCELLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f10254a = r0;
            }
        }

        b(Map<String, Object> r3, String r4, com.obric.memorydata.memory.tracker.d.b r5, n<? super Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r6) {
            Map<String, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            n<Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r8 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.memorydata.plugin");
            this.f10252a = r7;
            this.f10253b = r4;
            this.c = r5;
            this.d = r8;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r24) {
            Intrinsics.checkNotNullParameter(r24, "taskInfo");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM taskInfo: " + r24, false, 4, null);
            if (r24.c().isFinished() == true) goto L5;
            return;
        L5:
            int r2 = a.f10254a[r24.c().ordinal()];
            int r5 = 0;
            if (r2 == 1) goto L24;
            int r10 = 3;
            if (r2 == 2) goto L16;
            if (r2 != 3) goto L11;
            k r11 = k.f10296a;
            String r12 = this.f10253b;
            SessionStatus r13 = SessionStatus.ILLEGAL;
            String r14 = null;
            int r15 = 4;
            Object r16 = null;
        L15:
            k.a(r11, r12, r13, r14, r15, r16);
        L25:
            com.obric.memorydata.memory.tracker.d.b r1 = this.c;
            Object r3 = this.f10252a.get("errorCode");
            if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L28;
            Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin");
        L29:
            if (r4 == null) goto L31;
            r5 = r4.intValue();
        L31:
            Object r6 = this.f10252a.get(DTraitConstant.ERROR);
            if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L34;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        L35:
            if (r7 != null) goto L37;
            r7 = "";
        L37:
            r1.a(r5, r7);
            if (this.d.a() == false) goto L41;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM RESUME task", false, 4, null);
            this.d.a(TuplesKt.to(null, this.f10252a), null);
            return;
        L41:
            return;
        L34:
            r7 = null;
            goto L35
        L28:
            r4 = null;
            goto L29
        L11:
            if (k.f10296a.c(this.f10253b) == true) goto L13;
            this.f10252a.put("errorCode", -1000);
            this.f10252a.put(DTraitConstant.ERROR, "task success but session state is wrong");
            d.a(d.f10280a, this.f10253b, 3, null, null, null, 28, null);
            goto L25
        L13:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM success", false, 4, null);
            com.obric.memorydata.memory.tracker.d.b.a(this.c, 0, null, 3, null);
            goto L25
        L16:
            JSONObject r8 = r24.d();
            Map<String, Object> r9 = this.f10252a;
            String r17 = this.f10253b;
            int r18 = r8.optInt("realErrorCode", -1000);
            r9.put("errorCode", Integer.valueOf(r18));
            r9.put(DTraitConstant.ERROR, r8.optString("realErrorMsg", "task fail but no error msg"));
            d r19 = d.f10280a;
            if (r18 != (-7)) goto L19;
            r10 = 4;
        L19:
            d.a(r19, r17, r10, null, null, null, 28, null);
            r11 = k.f10296a;
            if (r18 != (-7)) goto L22;
            SessionStatus r20 = SessionStatus.ILLEGAL;
        L23:
            r13 = r20;
            r14 = null;
            r15 = 4;
            r16 = null;
            r12 = r17;
            goto L15
        L22:
            r20 = SessionStatus.FAILED;
            goto L23
        L24:
            this.f10252a.put("errorCode", Integer.valueOf(NetError.ERR_CERT_DATE_INVALID));
            d.a(d.f10280a, this.f10253b, 3, null, null, null, 28, null);
            k.a(k.f10296a, this.f10253b, SessionStatus.FAILED, null, 4, null);
            goto L25
        }
    }

    MemoryLLMBuildHelper$execute$2(e r3, Map<String, Object> r4, com.obric.memorydata.memory.memoryentity.f r5, boolean r6, String r7, MemoryEntity r8, PageContextResult r9, com.obric.memorydata.memory.tracker.d.b r10, Continuation<? super MemoryLLMBuildHelper$execute$2> r11) {
        Map<String, Object> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        this.$inputData = r3;
        this.$extraMap = r12;
        this.$memorySourceInfo = r5;
        this.$isDebug = r6;
        this.$sessionId = r7;
        this.$retryEntity = r8;
        this.$pageContextResult = r9;
        this.$trackingEvent = r10;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryLLMBuildHelper$execute$2(this.$inputData, this.$extraMap, this.$memorySourceInfo, this.$isDebug, this.$sessionId, this.$retryEntity, this.$pageContextResult, this.$trackingEvent, r10), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r4) {
        return ((MemoryLLMBuildHelper$execute$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryLLMBuildHelper$execute$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [T, com.obric.memorydata.task.AbsTaskRequest] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        com.obric.memorydata.memory.tracker.d.b r3 = (com.obric.memorydata.memory.tracker.d.b) ZeusTransformUtils.preCheckCast(this.L$6, com.obric.memorydata.memory.tracker.d.b.class, "com.obric.memorydata.plugin");
        PageContextResult r4 = (PageContextResult) ZeusTransformUtils.preCheckCast(this.L$5, PageContextResult.class, "com.obric.memorydata.plugin");
        MemoryEntity r5 = (MemoryEntity) ZeusTransformUtils.preCheckCast(this.L$4, MemoryEntity.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.L$3, String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.memoryentity.f r7 = (com.obric.memorydata.memory.memoryentity.f) ZeusTransformUtils.preCheckCast(this.L$2, com.obric.memorydata.memory.memoryentity.f.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(this.L$1, Map.class, "com.obric.memorydata.plugin");
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r23);
        return r23;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        e r9 = this.$inputData;
        Map<String, Object> r15 = this.$extraMap;
        com.obric.memorydata.memory.memoryentity.f r10 = this.$memorySourceInfo;
        boolean r11 = this.$isDebug;
        String r14 = this.$sessionId;
        MemoryEntity r13 = this.$retryEntity;
        PageContextResult r12 = this.$pageContextResult;
        com.obric.memorydata.memory.tracker.d.b r16 = this.$trackingEvent;
        this.L$0 = r9;
        this.L$1 = r15;
        this.L$2 = r10;
        this.L$3 = r14;
        this.L$4 = r13;
        this.L$5 = r12;
        this.L$6 = r16;
        this.Z$0 = r11;
        this.label = 1;
        o r17 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
        r17.e();
        n r18 = (n) ZeusTransformUtils.preCheckCast(r17, n.class, "com.obric.memorydata.plugin");
        long r19 = System.currentTimeMillis();
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        TaskRequest.Builder r21 = new TaskRequest.Builder("active_memory_build_large");
        JSONObject r22 = new JSONObject();
        r22.put("appName", r9.d());
        r22.put(ChatMessage.TYPE_QUERY, r9.a());
        r22.put("screenshotPath", r9.b());
        r22.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r9.c());
        r22.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r9.e());
        r22.put("activityName", r9.f());
        r22.put("chatHistory", r9.g());
        r22.put("refMemoryEntities", r9.p());
        r22.put("subIntent", r9.h());
        Unit r24 = Unit.INSTANCE;
        r20.element = ((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r21.setInputParam(r22), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setProgressCallback((Function1) ZeusTransformUtils.preCheckCast(new a(r15, r10, r11, r18, r14, r19, r13, r12, r20), Function1.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r15, r14, r16, r18), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(120000, TimeUnit.MILLISECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build();
        ((TaskRequest) ZeusTransformUtils.preCheckCast(r20.element, TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        Object r25 = r17.h();
        if (r25 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    L12:
        if (r25 != r1) goto L15;
        return r1;
    L15:
        return r25;
    }
}
