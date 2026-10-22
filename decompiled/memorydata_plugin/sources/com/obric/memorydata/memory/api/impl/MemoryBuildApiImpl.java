package com.obric.memorydata.memory.api.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.dc;
import com.obric.memorydata.database.entity.de;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.dc.d;
import com.obric.memorydata.memory.api.MemoryBuildApi;
import com.obric.memorydata.memory.llm.c;
import com.obric.memorydata.memory.llm.g;
import com.obric.memorydata.memory.llm.h;
import com.obric.memorydata.memory.memoryentity.ChatMessage;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.memory.memoryentity.b;
import com.obric.memorydata.memory.memoryentity.e;
import com.obric.memorydata.memory.memoryentity.f;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J*\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001d2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0002J2\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0002J\f\u0010!\u001a\u00020\u000e*\u00020\u000eH\u0002¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/api/impl/MemoryBuildApiImpl;", "Lcom/obric/memorydata/memory/api/MemoryBuildApi;", "<init>", "()V", "insertProactiveSemanticRelevantData", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveSemanticRelevantDataParams;", "insertProactiveEpisodicRelevantData", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveEpisodicRelevantDataParams;", "insertSourceEpisodicImageRelation", "sourceInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "entityId", "", "modifyTime", "", "shouldNotify", "", "insertSourceSemanticImageRelation", "hasMemorySource", "productType", "", "trackNewProactiveMemory", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$TrackNewProactiveMemoryParams;", "resolveProactiveSourceLinkBySession", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$SourceLinkInfo;", ObricMemoryConstants.KEY_SESSION_ID, "getRelevantAppSources", "Lkotlin/Pair;", "contentFrom", "getRelevantDataSources", "Lkotlin/Triple;", "toSummary", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBuildApiImpl implements MemoryBuildApi {
    public static final a Companion = null;
    private static final String TAG = "MemoryBuildApiImpl";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/api/impl/MemoryBuildApiImpl$Companion;", "", "<init>", "()V", "TAG", "", "getInst", "Lcom/obric/memorydata/memory/api/impl/MemoryBuildApiImpl;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final MemoryBuildApiImpl a() {
            return new MemoryBuildApiImpl();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.api.impl.MemoryBuildApiImpl$getRelevantDataSources$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.api.impl.MemoryBuildApiImpl$getRelevantDataSources$1", f = "MemoryBuildApiImpl.kt", i = {}, l = {354}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super FileEntity>, Object> {
        final /* synthetic */ f $sourceInfo;
        int label;

        AnonymousClass1(f r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$sourceInfo = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$sourceInfo, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super FileEntity> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super FileEntity> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            com.obric.memorydata.memory.memoryentity.a.a r2 = com.obric.memorydata.memory.memoryentity.a.a.f10310a;
            Bitmap r11 = this.$sourceInfo.d();
            e r3 = this.$sourceInfo.s();
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r10 = com.obric.memorydata.memory.memoryentity.a.a.a(r2, r11, r3, 0.0f, 0, r6, 12, null);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.api.impl.MemoryBuildApiImpl$getRelevantDataSources$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.api.impl.MemoryBuildApiImpl$getRelevantDataSources$2", f = "MemoryBuildApiImpl.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super FileEntity>, Object> {
        final /* synthetic */ f $sourceInfo;
        int label;

        AnonymousClass2(f r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$sourceInfo = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$sourceInfo, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super FileEntity> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super FileEntity> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            com.obric.memorydata.memory.memoryentity.a.a r2 = com.obric.memorydata.memory.memoryentity.a.a.f10310a;
            Bitmap r11 = this.$sourceInfo.d();
            e r3 = this.$sourceInfo.s();
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r10 = com.obric.memorydata.memory.memoryentity.a.a.a(r2, r11, r3, 0.0f, 0, r6, 12, null);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryBuildApiImpl() {
    }

    @JvmStatic
    public static final MemoryBuildApiImpl getInst() {
        return Companion.a();
    }

    private final Pair<String, String> getRelevantAppSources(f r1, String r2) {
        if (Intrinsics.areEqual(r2, "image") == true) goto L9;
        if (r1.a() != 3) goto L9;
        return new Pair(AppInfo.OAssistant.getAppName(), AppInfo.OAssistant.getPackageName());
    L9:
        return new Pair(r1.c(), r1.b());
    }

    private final Triple<String, String, String> getRelevantDataSources(f r8, String r9) {
        boolean r7 = true;
        String r1 = null;
        if (r9 == null) goto L69;
        int r2 = r9.hashCode();
        if (r2 == 100313435) goto L57;
        if (r2 == 107944136) goto L34;
        if (r2 != 951530927) goto L69;
        if (r9.equals("context") == false) goto L69;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.h(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L17;
    L20:
        if (r7 == true) goto L31;
        List<ChatMessage> r11 = com.obric.memorydata.memory.memoryentity.a.f10308a.a(r8.h());
        ListIterator<ChatMessage> r12 = r11.listIterator(r11.size());
    L23:
        if (r12.hasPrevious() == false) goto L27;
        ChatMessage r13 = r12.previous();
        if (Intrinsics.areEqual(((ChatMessage) ZeusTransformUtils.preCheckCast(r13, ChatMessage.class, "com.obric.memorydata.plugin")).getRoleType(), "user") == false) goto L23;
    L28:
        ChatMessage r14 = (ChatMessage) ZeusTransformUtils.preCheckCast(r13, ChatMessage.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L31;
        String r15 = r14.getContent();
    L32:
        r1 = r15;
        String r16 = r8.h();
        String r17 = null;
    L79:
        return new Triple(r1, r16, r17);
    L27:
        r13 = null;
    L31:
        r15 = null;
        goto L32
    L17:
        if (r10.length() == 0) goto L20;
        r7 = false;
        goto L20
    L34:
        if (r9.equals(com.obric.memorydata.database.entity.ChatMessage.TYPE_QUERY) == false) goto L69;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.h(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L39;
    L42:
        if (r7 == true) goto L55;
        List<ChatMessage> r19 = com.obric.memorydata.memory.memoryentity.a.f10308a.a(r8.h());
        ListIterator<ChatMessage> r20 = r19.listIterator(r19.size());
    L45:
        if (r20.hasPrevious() == false) goto L49;
        ChatMessage r21 = r20.previous();
        if (Intrinsics.areEqual(((ChatMessage) ZeusTransformUtils.preCheckCast(r21, ChatMessage.class, "com.obric.memorydata.plugin")).getRoleType(), "user") == false) goto L45;
    L50:
        ChatMessage r22 = (ChatMessage) ZeusTransformUtils.preCheckCast(r21, ChatMessage.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L53;
        String r23 = r22.getContent();
    L54:
        r17 = null;
        r1 = r23;
        r16 = null;
        goto L79
    L53:
        r23 = null;
        goto L54
    L49:
        r21 = null;
        goto L50
    L55:
        r16 = r8.v();
        r17 = null;
        goto L79
    L39:
        if (r18.length() == 0) goto L42;
        r7 = false;
        goto L42
    L57:
        if (r9.equals("image") == false) goto L69;
        FileEntity r24 = r8.e();
        if (r24 == null) goto L62;
    L65:
        if (r24 == null) goto L67;
        String r25 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r24, AppEntity.class, "com.obric.memorydata.plugin"));
    L68:
        r17 = r25;
        r16 = null;
        goto L79
    L67:
        r25 = null;
        goto L68
    L62:
        if (r8.d() == null) goto L64;
        r24 = (FileEntity) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), FileEntity.class, "com.obric.memorydata.plugin");
        goto L65
    L64:
        r24 = null;
    L69:
        String r26 = r8.w();
        String r3 = r8.v();
        FileEntity r4 = r8.e();
        if (r4 == null) goto L72;
    L75:
        if (r4 == null) goto L77;
        r1 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.memorydata.plugin"));
    L77:
        r17 = r1;
        r16 = r3;
        r1 = r26;
        goto L79
    L72:
        if (r8.d() == null) goto L74;
        r4 = (FileEntity) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), FileEntity.class, "com.obric.memorydata.plugin");
        goto L75
    L74:
        r4 = null;
        goto L75
    }

    private static final void insertProactiveEpisodicRelevantData$lambda$1(MemoryBuildApi.a r6) {
        MemoryEntityManager.executeCorrelationMemoryBuild$default(MemoryEntityManager.INSTANCE, r6.b(), 0, null, 6, null);
    }

    private final void insertSourceEpisodicImageRelation(f r17, String r18, long r19, boolean r21) {
        e r12 = r17.s();
        if (r12 != null) goto L6;
        return;
    L6:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12.b(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "skip source image relation without hash, entityId=" + r18 + ", uri=" + r12.a(), null, 4, null);
        return;
    L9:
        Long r1 = Long.valueOf(r19);
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L18;
        long r3 = r1.longValue();
    L19:
        long r7 = r3;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L25
        MemoryBuildApiImpl r5 = (MemoryBuildApiImpl) ZeusTransformUtils.preCheckCast(this, MemoryBuildApiImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemorySourceImageRelationDao().insertEpisodicRelation(new dc(0, r12.b(), r17.a(), r18, r7, 1, null));     // Catch: Throwable -> L25
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert episodic source image relation success, hash=" + StringsKt.take(r12.b(), 8) + ", entityId=" + r18 + ", productType=" + r17.a() + ", shouldNotify=" + r21, false, 4, null);     // Catch: Throwable -> L25
        if (r21 == false) goto L23;
        com.obric.memorydata.memory.c.a.f10081a.a(r12.b());     // Catch: Throwable -> L25
    L23:
        Object r0 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r0);
        if (r6 == null) goto L33;
        RunLog.INSTANCE.error(TAG, "insertSourceEpisodicImageRelation failed, entityId=" + r18, r6);
        return;
    L33:
        return;
    L25:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L27
    L18:
        r3 = System.currentTimeMillis();
        goto L19
    L12:
        r2 = false;
        goto L13
    }

    private final void insertSourceSemanticImageRelation(f r16, String r17, long r18) {
        e r0 = r16.s();
        if (r0 != null) goto L6;
        return;
    L6:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0.b(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "skip source image relation without hash, entityId=" + r17 + ", uri=" + r0.a(), null, 4, null);
        return;
    L9:
        Long r1 = Long.valueOf(r18);
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L18;
        long r3 = r1.longValue();
    L19:
        long r7 = r3;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L22
        MemoryBuildApiImpl r5 = (MemoryBuildApiImpl) ZeusTransformUtils.preCheckCast(this, MemoryBuildApiImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemorySourceImageRelationDao().insertSemanticRelation(new de(0, r0.b(), r16.a(), r17, r7, 1, null));     // Catch: Throwable -> L22
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert semantic source image relation success, hash=" + StringsKt.take(r0.b(), 8) + ", entityId=" + r17 + ", productType=" + r16.a(), false, 4, null);     // Catch: Throwable -> L22
        com.obric.memorydata.memory.c.a.f10081a.a(r0.b());     // Catch: Throwable -> L22
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r6);
        if (r8 == null) goto L30;
        RunLog.INSTANCE.error(TAG, "insertSourceSemanticImageRelation failed, entityId=" + r17, r8);
        return;
    L30:
        return;
    L22:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    L18:
        r3 = System.currentTimeMillis();
        goto L19
    L12:
        r2 = false;
        goto L13
    }

    public static /* synthetic */ void lambda$d5F3o6dLz2R0l_WZK6yBtmUV7Oo(MemoryBuildApi.a r0) {
        insertProactiveEpisodicRelevantData$lambda$1(r0);
    }

    private final String toSummary(String r8) {
        int r7 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), "**", 0, false, 6, null);
        if (r7 < 0) goto L6;
        r8 = r8.substring(0, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "substring(...)");
    L6:
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public boolean hasMemorySource(int r1) {
        if (MemoryEventTracker.MemorySource.Companion.a(r1) == MemoryEventTracker.MemorySource.UNKNOWN) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public void insertProactiveEpisodicRelevantData(final MemoryBuildApi.a r36) {
        Intrinsics.checkNotNullParameter(r36, TrackerImpl.PARAMS);
        RunLog.INSTANCE.debug(TAG, "insertProactiveEpisodicRelevantData params: " + r36);
        f r9 = g.f10287a.a(r36.a());
        if (r9 == null) goto L92;
        c r0 = r9.q();
        boolean r10 = false;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
    L17:
        Triple<String, String, String> r2 = getRelevantDataSources(r9, r36.l());
        String r17 = (String) ZeusTransformUtils.preCheckCast(r2.component1(), String.class, "com.obric.memorydata.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r2.component2(), String.class, "com.obric.memorydata.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r2.component3(), String.class, "com.obric.memorydata.plugin");
        Pair<String, String> r3 = getRelevantAppSources(r9, r36.l());
        String r23 = (String) ZeusTransformUtils.preCheckCast(r3.component1(), String.class, "com.obric.memorydata.plugin");
        String r22 = (String) ZeusTransformUtils.preCheckCast(r3.component2(), String.class, "com.obric.memorydata.plugin");
        d r4 = h.f10289a.a(r36.a());
        ProactiveEpisodicRelevantDataDao r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao();
        String r16 = r36.b();
        if (r4 == null) goto L20;
        String r19 = r4.a();
    L21:
        if (r4 == null) goto L23;
        String r20 = r4.b();
    L24:
        int r24 = r9.a();
        String r6 = r36.h();
        if (r6 == null) goto L27;
        String r27 = toSummary(r6);
    L28:
        String r26 = r36.j();
        if (r36.g().isSnapshotAction() == false) goto L31;
        int r28 = 1;
    L32:
        b r7 = r9.r();
        if (r7 == null) goto L35;
        String r29 = r7.a();
    L36:
        b r8 = r9.r();
        if (r8 == null) goto L39;
        String r30 = r8.b();
    L40:
        b r11 = r9.r();
        if (r11 == null) goto L43;
        String r31 = r11.c();
    L44:
        b r12 = r9.r();
        if (r12 == null) goto L47;
        Long r32 = Long.valueOf(r12.d());
    L48:
        r5.insert(new es(0, r16, r17, r18, r19, r20, r21, r22, r23, r24, null, r26, r27, r28, r29, r30, r31, r32, InputDeviceCompat.SOURCE_GAMEPAD, null));
        if (r0 == null) goto L51;
        r0.b(r36.b());
    L51:
        if (r0 != null) goto L53;
    L55:
        boolean r13 = false;
    L56:
        if (r13 == false) goto L59;
        IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder();
        String r25 = "stop episodic post-processing after cancellation: ";
    L15:
        IRunLog.a.a(r14, TAG, r15.append(r25).append(r36.b()).toString(), false, 4, null);
        return;
    L59:
        if (r36.g().isSnapshotAction() == false) goto L61;
        insertSourceEpisodicImageRelation(r9, r36.b(), r36.f(), com.obric.memorydata.memory.api.impl.a.a(r36.g()));
    L61:
        Collection r33 = (Collection) ZeusTransformUtils.preCheckCast(r36.i(), Collection.class, "com.obric.memorydata.plugin");
        if (r33 != null) goto L64;
    L67:
        boolean r34 = true;
    L68:
        if (r34 == true) goto L77;
        RunLog.INSTANCE.debug(TAG, "insertProactiveEpisodicRelevantData schedules: " + r36.i());
        List<MemoryBuildApi.Schedule> r35 = r36.i();
        if (r35 != null) goto L72;
        r35 = CollectionsKt.emptyList();
    L72:
        Iterable r37 = (Iterable) ZeusTransformUtils.preCheckCast(r35, Iterable.class, "com.obric.memorydata.plugin");
        Collection r38 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r37, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r39 = r37.iterator();
    L74:
        if (r39.hasNext() == false) goto L76;
        MemoryBuildApi.Schedule r40 = (MemoryBuildApi.Schedule) ZeusTransformUtils.preCheckCast(r39.next(), MemoryBuildApi.Schedule.class, "com.obric.memorydata.plugin");
        String r110 = r40.getTitle();
        String r41 = r40.getScheduleType().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r41, "toUpperCase(...)");
        r38.add(new PendingMemoryCalendar(0, r110, null, r41, null, r40.getStartTime(), r40.getEndTime(), null, r9.b(), r9.c(), r36.c(), Integer.valueOf(r36.d()), 0, 4245, null));
        goto L74
    L76:
        com.obric.memorydata.memory.calendar.b.f10085a.a((List) ZeusTransformUtils.preCheckCast(r38, List.class, "com.obric.memorydata.plugin"));
    L77:
        Map<String, List<String>> r42 = r36.k();
        if (r42 != null) goto L80;
    L81:
        r10 = true;
    L82:
        if (r10 == true) goto L88;
        Map<String, List<String>> r43 = r36.k();
        if (r43 != null) goto L86;
        r43 = MapsKt.emptyMap();
    L86:
        List<MemoryKeyInfoEntity> r44 = MemoryKeyInfoEntity.Companion.a(r36.b(), r43);
        RunLog.INSTANCE.debug(TAG, "insertProactiveEpisodicRelevantData keyInfoEntities: " + r44);
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryKeyInfoDao().batchInsert(r44);
    L88:
        if (r36.g().isSnapshotAction() == true) goto L93;
        trackNewProactiveMemory(new MemoryBuildApi.d(r36.c(), r9.a(), r9.b(), EntityType.MEMORY_COMMON_TEXT, null, r36.e(), r36.f(), r36.m(), true, null, null, r36.j(), 1536, null));
        new Handler(Looper.getMainLooper()).postDelayed(new $$Lambda$MemoryBuildApiImpl$d5F3o6dLz2R0l_WZK6yBtmUV7Oo(r36), 3000);
        return;
    L93:
        return;
    L80:
        if (r42.isEmpty() == false) goto L82;
    L64:
        if (r33.isEmpty() == true) goto L67;
        r34 = false;
        goto L68
    L53:
        if (r0.b() != true) goto L55;
        r13 = true;
        goto L56
    L47:
        r32 = null;
        goto L48
    L43:
        r31 = null;
        goto L44
    L39:
        r30 = null;
        goto L40
    L35:
        r29 = null;
        goto L36
    L31:
        r28 = 2;
        goto L32
    L27:
        r27 = null;
        goto L28
    L23:
        r20 = null;
        goto L24
    L20:
        r19 = null;
        goto L21
    L13:
        if (r0.c() == null) goto L17;
        r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r15 = new StringBuilder();
        r25 = "skip episodic relevant data after cancellation: ";
        goto L15
    L7:
        if (r0.b() != true) goto L9;
        r1 = true;
        goto L11
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public void insertProactiveSemanticRelevantData(MemoryBuildApi.b r24) {
        Intrinsics.checkNotNullParameter(r24, TrackerImpl.PARAMS);
        RunLog.INSTANCE.debug(TAG, "insertProactiveSemanticRelevantData params: " + r24);
        f r2 = g.f10287a.a(r24.a());
        if (r2 == null) goto L6;
        Triple<String, String, String> r3 = getRelevantDataSources(r2, r24.g());
        String r11 = (String) ZeusTransformUtils.preCheckCast(r3.component1(), String.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.component2(), String.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r3.component3(), String.class, "com.obric.memorydata.plugin");
        Pair<String, String> r4 = getRelevantAppSources(r2, r24.g());
        fa r5 = new fa(0, r24.b(), r11, r12, r13, (String) ZeusTransformUtils.preCheckCast(r4.component1(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.component2(), String.class, "com.obric.memorydata.plugin"), 0, r2.a(), 1, null);
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().insert(r5);
        com.obric.memorydata.database.c.f.f8859a.a(r5);
        insertSourceSemanticImageRelation(r2, r24.b(), r24.e());
        trackNewProactiveMemory(new MemoryBuildApi.d(r24.c(), r2.a(), r2.b(), EntityType.MEMORY_INFO_COMMON, iq.b(r24.f()), r24.d(), r24.e(), r24.h(), false, r24.i(), r24.j(), r24.k(), 256, null));
        return;
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public MemoryBuildApi.c resolveProactiveSourceLinkBySession(String r5) {
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_SESSION_ID);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return null;
    L5:
        d r4 = h.f10289a.a(r5);
        if (r4 == null) goto L17;
        String r2 = r4.a();
        if (r2 == null) goto L17;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L17;
        RunLog.INSTANCE.debug(TAG, "resolveProactiveSourceLinkBySession hit, sessionId=" + r5 + ", sourceLinkType=" + r4.b() + ", sourceLinkHash=" + r2.hashCode() + ", sourceLinkLength=" + r2.length());
        return new MemoryBuildApi.c(r2, r4.b());
    L17:
        return null;
    }

    @Override // com.obric.memorydata.memory.api.MemoryBuildApi
    public void trackNewProactiveMemory(MemoryBuildApi.d r17) {
        Intrinsics.checkNotNullParameter(r17, TrackerImpl.PARAMS);
        MemoryEventTracker r0 = MemoryEventTracker.f10515a;
        String r2 = r17.a();
        int r3 = r17.b();
        String r4 = r17.c();
        int r5 = r17.getType();
        String r6 = r17.d();
        String r15 = r17.k();
        r0.a(r2, r3, r4, r5, r6, r17.e(), r17.f(), r17.g(), r17.h(), r17.i(), r17.j(), r15);
    }
}
