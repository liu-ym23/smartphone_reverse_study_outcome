package com.obric.memorydata.database.entity;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0002¨\u0006 "}, d2 = {"Lcom/obric/memorydata/database/entity/RawPhotoIndexExtend;", "Lcom/obric/memorydata/database/index/DecoratedEntityIndex;", "delegate", "Lcom/obric/memorydata/database/index/BaseEntityIndex;", "<init>", "(Lcom/obric/memorydata/database/index/BaseEntityIndex;)V", "getNeedUpdateColumns", "", "", "oldRawEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "entity", "executeIndexPendingTask", "", "updateField", "updatePhotoLocation", "Lcom/obric/memorydata/database/entity/RawPhotoEntity;", "locationKey", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hg extends com.obric.memorydata.database.index.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9180a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/entity/RawPhotoIndexExtend$Companion;", "", "<init>", "()V", "COLUMN_CAPTION", "", "COLUMN_OCR", "COLUMN_TAG", "COLUMN_FILE", "COLUMN_LOCATION", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9180a = new a(null);
    }

    public hg(com.obric.memorydata.database.index.e r3) {
        com.obric.memorydata.database.index.e r4 = (com.obric.memorydata.database.index.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        super(r4);
    }

    private static final Unit a(hg r3, d r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IAppEntityRawDbDao<? extends d> r6 = r3.getRawDao();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawPhotoEntity>");
        List<T> r7 = r6.queryByEntityId(((hb) ZeusTransformUtils.preCheckCast(r4, hb.class, "com.obric.memorydata.plugin")).getEntityId(), ((hb) ZeusTransformUtils.preCheckCast(r4, hb.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        hb r8 = (hb) ZeusTransformUtils.preCheckCast(r7.get(0), hb.class, "com.obric.memorydata.plugin");
        r8.a(r5);
        r6.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v4 ??, still in use, count: 1, list:
          (r8v4 ?? I:java.lang.Object) from 0x00cc: INVOKE (r6v11 ?? I:java.lang.Object) = (r8v4 ?? I:java.lang.Object), (r6v10 ?? I:java.lang.Class), (r2v0 ?? I:java.lang.String) STATIC call: com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object A[MD:(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object (m)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private static final kotlin.Unit a(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v4 ??, still in use, count: 1, list:
          (r8v4 ?? I:java.lang.Object) from 0x00cc: INVOKE (r6v11 ?? I:java.lang.Object) = (r8v4 ?? I:java.lang.Object), (r6v10 ?? I:java.lang.Class), (r2v0 ?? I:java.lang.String) STATIC call: com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object A[MD:(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object (m)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r27v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    private final boolean a(hb r4, String r5) {
        IAppEntityRawDbDao<? extends d> r3 = getRawDao();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawPhotoEntity>");
        hb r6 = (hb) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r3.queryByEntityId(r4.getEntityId(), r4.getPackageName())), hb.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r6.l(), r5) == false) goto L8;
        return true;
    L8:
        r6.d(r5);
        if (r3.update(r6) > 0) goto L11;
        return false;
    L11:
        return true;
    }

    private static final boolean a(hg r5, d r6, gq r7) {
        Intrinsics.checkNotNullParameter(r7, "locationEntity");
        if (r7.m() == false) goto L6;
        return true;
    L6:
        if (com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null) == false) goto L10;
        PersonalContextAPI.INSTANCE.addLocation2MetaLocationManager(r7);
        return r5.a((hb) ZeusTransformUtils.preCheckCast(r6, hb.class, "com.obric.memorydata.plugin"), r7.getEntityId());
    L10:
        return false;
    }

    private static final Unit b(hg r6, d r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        IAppEntityRawDbDao<? extends d> r0 = r6.getRawDao();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawPhotoEntity>");
        List<T> r9 = r0.queryByEntityId(((hb) ZeusTransformUtils.preCheckCast(r7, hb.class, "com.obric.memorydata.plugin")).getEntityId(), ((hb) ZeusTransformUtils.preCheckCast(r7, hb.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        hb r10 = (hb) ZeusTransformUtils.preCheckCast(r9.get(0), hb.class, "com.obric.memorydata.plugin");
        r6.getEntityIndexHelperInstance().a(r10.getId(), r6.buildKeywordIndexMap((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin")));
        r10.b(r8);
        r0.update(r10);
        r6.getEntityIndexHelperInstance().b(r10.getId(), r6.buildKeywordIndexMap((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin")));
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$ctJdrRkFzltc0pozy2F_ZcCzxcU(hg r0, d r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$iMj6gwFnht0CgzkIfW1R2FQSBKs(hg r0, d r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$iYcz8fUB16RiYcAmysnQ1sEv7o8(hg r0, d r1, String r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$jV7QahzSnz9kawAx9BQONRXm6aE(hg r0, d r1, gq r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r3, d r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
        Intrinsics.checkNotNullParameter(r6, "changeColumns");
        super.assignmentAssociateField(r3, r4, r6);
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, hb.class) == false) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, hb.class) == false) goto L21;
        if (r6.contains("caption") == true) goto L12;
        ((hb) ZeusTransformUtils.preCheckCast(r4, hb.class, "com.obric.memorydata.plugin")).a(((hb) ZeusTransformUtils.preCheckCast(r3, hb.class, "com.obric.memorydata.plugin")).c());
    L12:
        if (r6.contains("ocr") == true) goto L15;
        ((hb) ZeusTransformUtils.preCheckCast(r4, hb.class, "com.obric.memorydata.plugin")).b(((hb) ZeusTransformUtils.preCheckCast(r3, hb.class, "com.obric.memorydata.plugin")).d());
    L15:
        if (r6.contains(LocationMonitorConst.TAG) == true) goto L18;
        ((hb) ZeusTransformUtils.preCheckCast(r4, hb.class, "com.obric.memorydata.plugin")).c(((hb) ZeusTransformUtils.preCheckCast(r3, hb.class, "com.obric.memorydata.plugin")).j());
    L18:
        if (r6.contains("location") == true) goto L25;
        ((hb) ZeusTransformUtils.preCheckCast(r4, hb.class, "com.obric.memorydata.plugin")).d(((hb) ZeusTransformUtils.preCheckCast(r3, hb.class, "com.obric.memorydata.plugin")).l());
        return;
    L25:
        return;
    L21:
        throw new IllegalStateException("Check failed.".toString());
    L23:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(final d r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "entity");
        Intrinsics.checkNotNullParameter(r10, "updateField");
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L41;
        if (ZeusTransformUtils.instanceOf(r9, hb.class) == false) goto L39;
        switch(r10.hashCode()) {
            case 109854: goto L34;
            case 114586: goto L29;
            case 3143036: goto L24;
            case 552573414: goto L19;
            case 1901043637: goto L10;
            default: goto L41;
        };
    L10:
        if (r10.equals("location") == false) goto L41;
        gq r11 = (gq) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaLocationRawDbDao().queryByEntityId(((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin")).getEntityId(), ((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin")).getPackageName())), gq.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L17;
        Function1<? super gq, Boolean> r12 = new $$Lambda$hg$jV7QahzSnz9kawAx9BQONRXm6aE(this, r9);
        return getEntityIndexHelperInstance().a((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin"), r12);
    L17:
        return a((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin"), r11.getEntityId());
    L19:
        if (r10.equals("caption") == false) goto L41;
        Function1<? super String, Unit> r7 = new $$Lambda$hg$iMj6gwFnht0CgzkIfW1R2FQSBKs(this, r9);
        return getEntityIndexHelperInstance().b(r9, "caption", ((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin")).a(), "", r7);
    L24:
        if (r10.equals("file") == false) goto L41;
        return getEntityIndexHelperInstance().b(r9, "file", ((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin")).a(), false);
    L29:
        if (r10.equals(LocationMonitorConst.TAG) == false) goto L41;
        Function1<? super List<String>, Unit> r13 = new $$Lambda$hg$ctJdrRkFzltc0pozy2F_ZcCzxcU(this, r9);
        return getEntityIndexHelperInstance().a(r9, ((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin")).a(), r13);
    L34:
        if (r10.equals("ocr") == false) goto L41;
        Function1<? super String, Unit> r8 = new $$Lambda$hg$iYcz8fUB16RiYcAmysnQ1sEv7o8(this, r9);
        return getEntityIndexHelperInstance().a(r9, "ocr", ((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin")).a(), "common2", r8);
    L39:
        throw new IllegalStateException("Check failed.".toString());
    L41:
        return super.executeIndexPendingTask(r9, r10);
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r25, d r26) {
        Intrinsics.checkNotNullParameter(r25, "columnName");
        Intrinsics.checkNotNullParameter(r26, "entity");
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L53;
        if (ZeusTransformUtils.instanceOf(r26, hb.class) == false) goto L51;
        switch(r25.hashCode()) {
            case 109854: goto L43;
            case 114586: goto L33;
            case 3143036: goto L25;
            case 552573414: goto L15;
            case 1901043637: goto L10;
            default: goto L53;
        };
    L10:
        if (r25.equals("location") == false) goto L53;
        return CollectionsKt.listOf(new cd(0, ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getId(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getType(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r25, "location", 0, 0, null, false, 0, 0, 32353, null));
    L15:
        if (r25.equals("caption") == false) goto L53;
        ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).a();
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L23;
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L23;
        return CollectionsKt.listOf(new cd(0, ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getId(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getType(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r25, "caption", 0, 0, null, false, 0, 0, 32353, null));
    L23:
        return CollectionsKt.emptyList();
    L25:
        if (r25.equals("file") == false) goto L53;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L31;
        return getEntityIndexHelperInstance().a(r26, r25, ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).a(), false);
    L31:
        return CollectionsKt.emptyList();
    L33:
        if (r25.equals(LocationMonitorConst.TAG) == false) goto L53;
        ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).a();
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L41;
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L41;
        return CollectionsKt.listOf(new cd(0, ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getId(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getType(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r25, LocationMonitorConst.TAG, 0, 0, null, false, 0, 0, 32353, null));
    L41:
        return CollectionsKt.emptyList();
    L43:
        if (r25.equals("ocr") == false) goto L53;
        ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).a();
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L49;
        return CollectionsKt.listOf(new cd(0, ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getId(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getType(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hb) ZeusTransformUtils.preCheckCast(r26, hb.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r25, "ocr", 0, 0, null, false, 0, 0, 32353, null));
    L49:
        return CollectionsKt.emptyList();
    L51:
        throw new IllegalStateException("Check failed.".toString());
    L53:
        return super.generateIndexPendingTask(r25, r26);
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = super.getAllColumns();
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L5;
        r2.add(LocationMonitorConst.TAG);
        r2.add("location");
    L5:
        return r2;
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public Set<String> getNeedUpdateColumns(d r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "oldRawEntity");
        Intrinsics.checkNotNullParameter(r3, "newRawEntity");
        Set<String> r1 = super.getNeedUpdateColumns(r2, r3);
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L5;
    L8:
        return r1;
    L5:
        if (r1.contains("file") == false) goto L7;
        r1.add("caption");
        r1.add("ocr");
        r1.add(LocationMonitorConst.TAG);
        r1.add("location");
        goto L8
    L7:
        r1.remove("caption");
        r1.remove("ocr");
        goto L8
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = super.getPendingTaskColumns();
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L5;
        r2.add(LocationMonitorConst.TAG);
        r2.add("location");
    L5:
        return r2;
    }
}
