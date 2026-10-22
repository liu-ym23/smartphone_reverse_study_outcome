package com.tencent.wcdb.core;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.chaincall.Delete;
import com.tencent.wcdb.chaincall.Insert;
import com.tencent.wcdb.chaincall.Select;
import com.tencent.wcdb.chaincall.Update;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.orm.TableBinding;
import com.tencent.wcdb.winq.Expression;
import com.tencent.wcdb.winq.OrderingTerm;
import com.tencent.wcdb.winq.StatementDropIndex;
import com.tencent.wcdb.winq.StatementDropTable;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class HandleORMOperation extends HandleOperation {
    public abstract Database getDatabase();

    public Delete prepareDelete() {
        return new Delete(getHandle(true), false, autoInvalidateHandle());
    }

    public <T> Insert<T> prepareInsert() {
        return new Insert(getHandle(true), false, autoInvalidateHandle());
    }

    public <T> Select<T> prepareSelect() {
        return new Select(getHandle(false), false, autoInvalidateHandle());
    }

    public <T> Update<T> prepareUpdate() {
        return new Update(getHandle(true), false, autoInvalidateHandle());
    }

    public HandleORMOperation() {
    }

    public void deleteObjects(String r2) throws WCDBException {
        prepareDelete().fromTable(r2).execute();
    }

    public void dropIndex(String r2) throws WCDBException {
        execute(new StatementDropIndex().dropIndex(r2).ifExist());
    }

    public void dropTable(String r2) throws WCDBException {
        execute(new StatementDropTable().dropTable(r2).ifExist());
    }

    public boolean tableExist(String r6) throws WCDBException {
        Handle r1 = getHandle(false);
        int r7 = Handle.tableExist(((CppObject) r1).cppObj, r6);
        if (r7 <= 1) goto L5;
        WCDBException r3 = r1.createException();
    L7:
        if (autoInvalidateHandle() == false) goto L9;
        r1.invalidate();
    L9:
        if (r3 != null) goto L13;
        if (r7 != 1) goto L14;
        return true;
    L14:
        return false;
    L13:
        throw r3;
    L5:
        r3 = null;
        goto L7
    }

    public <T> void createTable(String r2, TableBinding<T> r3) throws WCDBException {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
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
        /*
            this = this;
            r0 = 1
            com.tencent.wcdb.core.Handle r0 = r1.getHandle(r0)
            com.tencent.wcdb.orm.Binding r3 = r3.baseBinding()     // Catch: java.lang.Throwable -> L20
            boolean r2 = r3.createTable(r2, r0)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L1b
            boolean r2 = r1.autoInvalidateHandle()
            if (r2 == 0) goto L1a
            if (r0 == 0) goto L1a
            r0.invalidate()
        L1a:
            return
        L1b:
            com.tencent.wcdb.base.WCDBException r2 = r0.createException()     // Catch: java.lang.Throwable -> L20
            throw r2     // Catch: java.lang.Throwable -> L20
        L20:
            r2 = move-exception
            boolean r3 = r1.autoInvalidateHandle()
            if (r3 == 0) goto L2c
            if (r0 == 0) goto L2c
            r0.invalidate()
        L2c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.core.HandleORMOperation.createTable(java.lang.String, com.tencent.wcdb.orm.TableBinding):void");
    }

    public <T> void createVirtualTable(String r2, TableBinding<T> r3) throws WCDBException {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
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
        /*
            this = this;
            r0 = 1
            com.tencent.wcdb.core.Handle r0 = r1.getHandle(r0)
            com.tencent.wcdb.orm.Binding r3 = r3.baseBinding()     // Catch: java.lang.Throwable -> L20
            boolean r2 = r3.createVirtualTable(r2, r0)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L1b
            boolean r2 = r1.autoInvalidateHandle()
            if (r2 == 0) goto L1a
            if (r0 == 0) goto L1a
            r0.invalidate()
        L1a:
            return
        L1b:
            com.tencent.wcdb.base.WCDBException r2 = r0.createException()     // Catch: java.lang.Throwable -> L20
            throw r2     // Catch: java.lang.Throwable -> L20
        L20:
            r2 = move-exception
            boolean r3 = r1.autoInvalidateHandle()
            if (r3 == 0) goto L2c
            if (r0 == 0) goto L2c
            r0.invalidate()
        L2c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.core.HandleORMOperation.createVirtualTable(java.lang.String, com.tencent.wcdb.orm.TableBinding):void");
    }

    public void deleteObjects(String r2, Expression r3) throws WCDBException {
        prepareDelete().fromTable(r2).where(r3).execute();
    }

    public <T> List<T> getAllObjects(Field<T>[] r2, String r3) throws WCDBException {
        return prepareSelect().select(r2).from(r3).allObjects();
    }

    public <T> T getFirstObject(Field<T>[] r2, String r3) throws WCDBException {
        return (T) prepareSelect().select(r2).from(r3).firstObject();
    }

    public <T> Table<T> getTable(String r3, TableBinding<T> r4) {
        return new Table(r3, r4, getDatabase());
    }

    public void deleteObjects(String r3, OrderingTerm r4, long r5) throws WCDBException {
        prepareDelete().fromTable(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).execute();
    }

    public <T> List<T> getAllObjects(Field<T>[] r2, String r3, Expression r4) throws WCDBException {
        return prepareSelect().select(r2).from(r3).where(r4).allObjects();
    }

    public <T> T getFirstObject(Field<T>[] r2, String r3, Expression r4) throws WCDBException {
        return (T) prepareSelect().select(r2).from(r3).where(r4).firstObject();
    }

    public <T> void insertObject(T r2, Field<T>[] r3, String r4) throws WCDBException {
        prepareInsert().intoTable(r4).value(r2).onFields(r3).execute();
    }

    public <T> void insertObjects(Collection<T> r2, Field<T>[] r3, String r4) throws WCDBException {
        prepareInsert().intoTable(r4).values(r2).onFields(r3).execute();
    }

    public <T> void insertOrIgnoreObject(T r2, Field<T>[] r3, String r4) throws WCDBException {
        prepareInsert().orIgnore().intoTable(r4).value(r2).onFields(r3).execute();
    }

    public <T> void insertOrIgnoreObjects(Collection<T> r2, Field<T>[] r3, String r4) throws WCDBException {
        prepareInsert().orIgnore().intoTable(r4).values(r2).onFields(r3).execute();
    }

    public <T> void insertOrReplaceObject(T r2, Field<T>[] r3, String r4) throws WCDBException {
        prepareInsert().orReplace().intoTable(r4).value(r2).onFields(r3).execute();
    }

    public <T> void insertOrReplaceObjects(Collection<T> r2, Field<T>[] r3, String r4) throws WCDBException {
        prepareInsert().orReplace().intoTable(r4).values(r2).onFields(r3).execute();
    }

    public <T> void updateObject(T r3, Field<T> r4, String r5) throws WCDBException {
        prepareUpdate().table(r5).set(new Field[]{r4}).toObject(r3).execute();
    }

    public <T> List<T> getAllObjects(Field<T>[] r2, String r3, OrderingTerm r4) throws WCDBException {
        return prepareSelect().select(r2).from(r3).orderBy(r4).allObjects();
    }

    public <T> T getFirstObject(Field<T>[] r2, String r3, OrderingTerm r4) throws WCDBException {
        return (T) prepareSelect().select(r2).from(r3).orderBy(r4).firstObject();
    }

    public <T> void updateObject(T r2, Field<T>[] r3, String r4) throws WCDBException {
        prepareUpdate().table(r4).set(r3).toObject(r2).execute();
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r2, String r3, Class<R> r4) throws WCDBException {
        return prepareSelect().select(r2).from(r3).allObjects(r4);
    }

    public <T, R extends T> R getFirstObject(Field<T>[] r2, String r3, Class<R> r4) throws WCDBException {
        return (R) prepareSelect().select(r2).from(r3).firstObject(r4);
    }

    public void deleteObjects(String r2, Expression r3, OrderingTerm r4, long r5) throws WCDBException {
        prepareDelete().fromTable(r2).where(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).execute();
    }

    public <T> List<T> getAllObjects(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5) throws WCDBException {
        return prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).allObjects();
    }

    public <T> T getFirstObject(Field<T>[] r2, String r3, OrderingTerm r4, long r5) throws WCDBException {
        return (T) prepareSelect().select(r2).from(r3).orderBy(r4).limit(1).offset(r5).firstObject();
    }

    public <T> void updateObject(T r3, Field<T> r4, String r5, Expression r6) throws WCDBException {
        prepareUpdate().table(r5).set(new Field[]{r4}).toObject(r3).where(r6).execute();
    }

    public void deleteObjects(String r3, OrderingTerm r4, long r5, long r7) throws WCDBException {
        prepareDelete().fromTable(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).offset(r7).execute();
    }

    public <T> List<T> getAllObjects(Field<T>[] r2, String r3, OrderingTerm r4, long r5) throws WCDBException {
        return prepareSelect().select(r2).from(r3).orderBy(r4).limit(r5).allObjects();
    }

    public <T> T getFirstObject(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5) throws WCDBException {
        return (T) prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).firstObject();
    }

    public <T> void updateObject(T r2, Field<T>[] r3, String r4, Expression r5) throws WCDBException {
        prepareUpdate().table(r4).set(r3).toObject(r2).where(r5).execute();
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r2, String r3, Expression r4, Class<R> r5) throws WCDBException {
        return prepareSelect().select(r2).from(r3).where(r4).allObjects(r5);
    }

    public <T, R extends T> R getFirstObject(Field<T>[] r2, String r3, Expression r4, Class<R> r5) throws WCDBException {
        return (R) prepareSelect().select(r2).from(r3).where(r4).firstObject(r5);
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r2, String r3, OrderingTerm r4, Class<R> r5) throws WCDBException {
        return prepareSelect().select(r2).from(r3).orderBy(r4).allObjects(r5);
    }

    public <T, R extends T> R getFirstObject(Field<T>[] r2, String r3, OrderingTerm r4, Class<R> r5) throws WCDBException {
        return (R) prepareSelect().select(r2).from(r3).orderBy(r4).firstObject(r5);
    }

    public void deleteObjects(String r2, Expression r3, OrderingTerm r4, long r5, long r7) throws WCDBException {
        prepareDelete().fromTable(r2).where(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).offset(r7).execute();
    }

    public <T> List<T> getAllObjects(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5, long r6) throws WCDBException {
        return prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).limit(r6).allObjects();
    }

    public <T> T getFirstObject(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5, long r6) throws WCDBException {
        return (T) prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).limit(1).offset(r6).firstObject();
    }

    public <T> void updateObject(T r3, Field<T> r4, String r5, OrderingTerm r6, long r7) throws WCDBException {
        prepareUpdate().table(r5).set(new Field[]{r4}).toObject(r3).orderBy(r6).limit(r7).execute();
    }

    public <T> List<T> getAllObjects(Field<T>[] r2, String r3, OrderingTerm r4, long r5, long r7) throws WCDBException {
        return prepareSelect().select(r2).from(r3).orderBy(r4).limit(r5).offset(r7).allObjects();
    }

    public <T, R extends T> R getFirstObject(Field<T>[] r2, String r3, OrderingTerm r4, long r5, Class<R> r7) throws WCDBException {
        return (R) prepareSelect().select(r2).from(r3).orderBy(r4).limit(1).offset(r5).firstObject(r7);
    }

    public <T> void updateObject(T r2, Field<T>[] r3, String r4, OrderingTerm r5, long r6) throws WCDBException {
        prepareUpdate().table(r4).set(r3).toObject(r2).orderBy(r5).limit(r6).execute();
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5, Class<R> r6) throws WCDBException {
        return prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).allObjects(r6);
    }

    public <T, R extends T> R getFirstObject(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5, Class<R> r6) throws WCDBException {
        return (R) prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).firstObject(r6);
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r2, String r3, OrderingTerm r4, long r5, Class<R> r7) throws WCDBException {
        return prepareSelect().select(r2).from(r3).orderBy(r4).limit(r5).allObjects(r7);
    }

    public <T> List<T> getAllObjects(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5, long r6, long r8) throws WCDBException {
        return prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).limit(r6).offset(r8).allObjects();
    }

    public <T, R extends T> R getFirstObject(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5, long r6, Class<R> r8) throws WCDBException {
        return (R) prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).limit(1).offset(r6).firstObject(r8);
    }

    public <T> void updateObject(T r3, Field<T> r4, String r5, Expression r6, OrderingTerm r7, long r8) throws WCDBException {
        prepareUpdate().table(r5).set(new Field[]{r4}).toObject(r3).where(r6).orderBy(r7).limit(r8).execute();
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5, long r6, Class<R> r8) throws WCDBException {
        return prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).limit(r6).allObjects(r8);
    }

    public <T> void updateObject(T r3, Field<T> r4, String r5, OrderingTerm r6, long r7, long r9) throws WCDBException {
        prepareUpdate().table(r5).set(new Field[]{r4}).toObject(r3).orderBy(r6).limit(r7).offset(r9).execute();
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r2, String r3, OrderingTerm r4, long r5, long r7, Class<R> r9) throws WCDBException {
        return prepareSelect().select(r2).from(r3).orderBy(r4).limit(r5).offset(r7).allObjects(r9);
    }

    public <T> void updateObject(T r2, Field<T>[] r3, String r4, Expression r5, OrderingTerm r6, long r7) throws WCDBException {
        prepareUpdate().table(r4).set(r3).toObject(r2).where(r5).orderBy(r6).limit(r7).execute();
    }

    public <T> void updateObject(T r2, Field<T>[] r3, String r4, OrderingTerm r5, long r6, long r8) throws WCDBException {
        prepareUpdate().table(r4).set(r3).toObject(r2).orderBy(r5).limit(r6).offset(r8).execute();
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r2, String r3, Expression r4, OrderingTerm r5, long r6, long r8, Class<R> r10) throws WCDBException {
        return prepareSelect().select(r2).from(r3).where(r4).orderBy(r5).limit(r6).offset(r8).allObjects(r10);
    }

    public <T> void updateObject(T r3, Field<T> r4, String r5, Expression r6, OrderingTerm r7, long r8, long r10) throws WCDBException {
        prepareUpdate().table(r5).set(new Field[]{r4}).toObject(r3).where(r6).orderBy(r7).limit(r8).offset(r10).execute();
    }

    public <T> void updateObject(T r2, Field<T>[] r3, String r4, Expression r5, OrderingTerm r6, long r7, long r9) throws WCDBException {
        prepareUpdate().table(r4).set(r3).toObject(r2).where(r5).orderBy(r6).limit(r7).offset(r9).execute();
    }
}
