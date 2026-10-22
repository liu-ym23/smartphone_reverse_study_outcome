package com.tencent.wcdb.core;

import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.chaincall.Delete;
import com.tencent.wcdb.chaincall.Insert;
import com.tencent.wcdb.chaincall.Select;
import com.tencent.wcdb.chaincall.Update;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.orm.TableBinding;
import com.tencent.wcdb.winq.Expression;
import com.tencent.wcdb.winq.OrderingTerm;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TableORMOperation<T> extends TableOperation {
    TableBinding<T> binding;

    public Delete prepareDelete() throws WCDBException {
        Delete r0 = new Delete(this.database.getHandle(true), false, true);
        r0.fromTable(this.tableName);
        return r0;
    }

    public Insert<T> prepareInsert() {
        Insert<T> r0 = new Insert(this.database.getHandle(true), false, true);
        r0.intoTable(this.tableName);
        return r0;
    }

    public Select<T> prepareSelect() {
        Select<T> r0 = new Select(this.database.getHandle(false), false, true);
        r0.from(this.tableName);
        return r0;
    }

    public Update<T> prepareUpdate() {
        Update<T> r0 = new Update(this.database.getHandle(true), false, true);
        r0.table(this.tableName);
        return r0;
    }

    public TableORMOperation() {
        this.binding = null;
    }

    public void deleteObjects() throws WCDBException {
        prepareDelete().execute();
    }

    public List<T> getAllObjects() throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).allObjects();
    }

    public T getFirstObject() throws WCDBException {
        return (T) prepareSelect().select(this.binding.allBindingFields()).firstObject();
    }

    public TableBinding<T> getBinding() {
        return this.binding;
    }

    public void deleteObjects(Expression r2) throws WCDBException {
        prepareDelete().where(r2).execute();
    }

    public List<T> getAllObjects(Expression r3) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r3).allObjects();
    }

    public T getFirstObject(Expression r3) throws WCDBException {
        return (T) prepareSelect().select(this.binding.allBindingFields()).where(r3).firstObject();
    }

    public void insertObject(T r2) throws WCDBException {
        prepareInsert().value(r2).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertObjects(Collection<T> r2) throws WCDBException {
        prepareInsert().values(r2).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertOrIgnoreObject(T r2) throws WCDBException {
        prepareInsert().orIgnore().value(r2).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertOrIgnoreObjects(Collection<T> r2) throws WCDBException {
        prepareInsert().orIgnore().values(r2).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertOrReplaceObject(T r2) throws WCDBException {
        prepareInsert().orReplace().value(r2).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertOrReplaceObjects(Collection<T> r2) throws WCDBException {
        prepareInsert().orReplace().values(r2).onFields(this.binding.allBindingFields()).execute();
    }

    public void updateObject(T r3) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r3).execute();
    }

    public List<T> getAllObjects(OrderingTerm r3) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).allObjects();
    }

    public T getFirstObject(OrderingTerm r3) throws WCDBException {
        return (T) prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).firstObject();
    }

    public <R extends T> List<R> getAllObjects(Class<R> r3) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).allObjects(r3);
    }

    public <R extends T> R getFirstObject(Class<R> r3) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).firstObject(r3);
    }

    public List<T> getAllObjects(Field<T>[] r2) throws WCDBException {
        return prepareSelect().select(r2).allObjects();
    }

    public T getFirstObject(Field<T>[] r2) throws WCDBException {
        return (T) prepareSelect().select(r2).firstObject();
    }

    public void deleteObjects(OrderingTerm r4, long r5) throws WCDBException {
        prepareDelete().orderBy(new OrderingTerm[]{r4}).limit(r5).execute();
    }

    public List<T> getAllObjects(Expression r3, OrderingTerm r4) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).allObjects();
    }

    public T getFirstObject(OrderingTerm r3, long r4) throws WCDBException {
        return (T) prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).limit(1).offset(r4).firstObject();
    }

    public void insertObject(T r2, Field<T>[] r3) throws WCDBException {
        prepareInsert().value(r2).onFields(r3).execute();
    }

    public void insertObjects(Collection<T> r2, Field<T>[] r3) throws WCDBException {
        prepareInsert().values(r2).onFields(r3).execute();
    }

    public void insertOrIgnoreObject(T r2, Field<T>[] r3) throws WCDBException {
        prepareInsert().orIgnore().value(r2).onFields(r3).execute();
    }

    public void insertOrIgnoreObjects(Collection<T> r2, Field<T>[] r3) throws WCDBException {
        prepareInsert().orIgnore().values(r2).onFields(r3).execute();
    }

    public void insertOrReplaceObject(T r2, Field<T>[] r3) throws WCDBException {
        prepareInsert().orReplace().value(r2).onFields(r3).execute();
    }

    public void insertOrReplaceObjects(Collection<T> r2, Field<T>[] r3) throws WCDBException {
        prepareInsert().orReplace().values(r2).onFields(r3).execute();
    }

    public void updateObject(T r3, Expression r4) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r3).where(r4).execute();
    }

    public List<T> getAllObjects(OrderingTerm r3, long r4) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).limit(r4).allObjects();
    }

    public T getFirstObject(Expression r3, OrderingTerm r4) throws WCDBException {
        return (T) prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).firstObject();
    }

    public void updateObject(T r4, Field<T> r5) throws WCDBException {
        prepareUpdate().set(new Field[]{r5}).toObject(r4).execute();
    }

    public <R extends T> List<R> getAllObjects(Expression r3, Class<R> r4) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r3).allObjects(r4);
    }

    public <R extends T> R getFirstObject(Expression r3, Class<R> r4) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).where(r3).firstObject(r4);
    }

    public void updateObject(T r2, Field<T>[] r3) throws WCDBException {
        prepareUpdate().set(r3).toObject(r2).execute();
    }

    public <R extends T> List<R> getAllObjects(OrderingTerm r3, Class<R> r4) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).allObjects(r4);
    }

    public <R extends T> R getFirstObject(OrderingTerm r3, Class<R> r4) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).firstObject(r4);
    }

    public List<T> getAllObjects(Field<T>[] r2, Expression r3) throws WCDBException {
        return prepareSelect().select(r2).where(r3).allObjects();
    }

    public T getFirstObject(Field<T>[] r2, Expression r3) throws WCDBException {
        return (T) prepareSelect().select(r2).where(r3).firstObject();
    }

    public List<T> getAllObjects(Field<T>[] r2, OrderingTerm r3) throws WCDBException {
        return prepareSelect().select(r2).orderBy(r3).allObjects();
    }

    public T getFirstObject(Field<T>[] r2, OrderingTerm r3) throws WCDBException {
        return (T) prepareSelect().select(r2).orderBy(r3).firstObject();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r2, Class<R> r3) throws WCDBException {
        return prepareSelect().select(r2).allObjects(r3);
    }

    public <R extends T> R getFirstObject(Field<T>[] r2, Class<R> r3) throws WCDBException {
        return (R) prepareSelect().select(r2).firstObject(r3);
    }

    public void deleteObjects(Expression r3, OrderingTerm r4, long r5) throws WCDBException {
        prepareDelete().where(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).execute();
    }

    public List<T> getAllObjects(Expression r3, OrderingTerm r4, long r5) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).limit(r5).allObjects();
    }

    public T getFirstObject(Expression r3, OrderingTerm r4, long r5) throws WCDBException {
        return (T) prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).limit(1).offset(r5).firstObject();
    }

    public void updateObject(T r3, OrderingTerm r4, long r5) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r3).orderBy(r4).limit(r5).execute();
    }

    public void deleteObjects(OrderingTerm r4, long r5, long r7) throws WCDBException {
        prepareDelete().orderBy(new OrderingTerm[]{r4}).limit(r5).offset(r7).execute();
    }

    public List<T> getAllObjects(OrderingTerm r3, long r4, long r6) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).limit(r4).offset(r6).allObjects();
    }

    public <R extends T> R getFirstObject(OrderingTerm r3, long r4, Class<R> r6) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).limit(1).offset(r4).firstObject(r6);
    }

    public void updateObject(T r4, Field<T> r5, Expression r6) throws WCDBException {
        prepareUpdate().set(new Field[]{r5}).toObject(r4).where(r6).execute();
    }

    public <R extends T> List<R> getAllObjects(Expression r3, OrderingTerm r4, Class<R> r5) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).allObjects(r5);
    }

    public <R extends T> R getFirstObject(Expression r3, OrderingTerm r4, Class<R> r5) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).firstObject(r5);
    }

    public void updateObject(T r2, Field<T>[] r3, Expression r4) throws WCDBException {
        prepareUpdate().set(r3).toObject(r2).where(r4).execute();
    }

    public <R extends T> List<R> getAllObjects(OrderingTerm r3, long r4, Class<R> r6) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).limit(r4).allObjects(r6);
    }

    public T getFirstObject(Field<T>[] r3, OrderingTerm r4, long r5) throws WCDBException {
        return (T) prepareSelect().select(r3).orderBy(r4).limit(1).offset(r5).firstObject();
    }

    public List<T> getAllObjects(Field<T>[] r2, Expression r3, OrderingTerm r4) throws WCDBException {
        return prepareSelect().select(r2).where(r3).orderBy(r4).allObjects();
    }

    public T getFirstObject(Field<T>[] r2, Expression r3, OrderingTerm r4) throws WCDBException {
        return (T) prepareSelect().select(r2).where(r3).orderBy(r4).firstObject();
    }

    public List<T> getAllObjects(Field<T>[] r2, OrderingTerm r3, long r4) throws WCDBException {
        return prepareSelect().select(r2).orderBy(r3).limit(r4).allObjects();
    }

    public <R extends T> R getFirstObject(Field<T>[] r2, Expression r3, Class<R> r4) throws WCDBException {
        return (R) prepareSelect().select(r2).where(r3).firstObject(r4);
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r2, Expression r3, Class<R> r4) throws WCDBException {
        return prepareSelect().select(r2).where(r3).allObjects(r4);
    }

    public <R extends T> R getFirstObject(Field<T>[] r2, OrderingTerm r3, Class<R> r4) throws WCDBException {
        return (R) prepareSelect().select(r2).orderBy(r3).firstObject(r4);
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r2, OrderingTerm r3, Class<R> r4) throws WCDBException {
        return prepareSelect().select(r2).orderBy(r3).allObjects(r4);
    }

    public void deleteObjects(Expression r3, OrderingTerm r4, long r5, long r7) throws WCDBException {
        prepareDelete().where(r3).orderBy(new OrderingTerm[]{r4}).limit(r5).offset(r7).execute();
    }

    public List<T> getAllObjects(Expression r3, OrderingTerm r4, long r5, long r7) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).limit(r5).offset(r7).allObjects();
    }

    public <R extends T> R getFirstObject(Expression r3, OrderingTerm r4, long r5, Class<R> r7) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).limit(1).offset(r5).firstObject(r7);
    }

    public void updateObject(T r3, Expression r4, OrderingTerm r5, long r6) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r3).where(r4).orderBy(r5).limit(r6).execute();
    }

    public <R extends T> List<R> getAllObjects(Expression r3, OrderingTerm r4, long r5, Class<R> r7) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).limit(r5).allObjects(r7);
    }

    public T getFirstObject(Field<T>[] r2, Expression r3, OrderingTerm r4, long r5) throws WCDBException {
        return (T) prepareSelect().select(r2).where(r3).orderBy(r4).limit(1).offset(r5).firstObject();
    }

    public void updateObject(T r3, OrderingTerm r4, long r5, long r7) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r3).orderBy(r4).limit(r5).offset(r7).execute();
    }

    public <R extends T> List<R> getAllObjects(OrderingTerm r3, long r4, long r6, Class<R> r8) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r3).limit(r4).offset(r6).allObjects(r8);
    }

    public <R extends T> R getFirstObject(Field<T>[] r3, OrderingTerm r4, long r5, Class<R> r7) throws WCDBException {
        return (R) prepareSelect().select(r3).orderBy(r4).limit(1).offset(r5).firstObject(r7);
    }

    public void updateObject(T r4, Field<T> r5, OrderingTerm r6, long r7) throws WCDBException {
        prepareUpdate().set(new Field[]{r5}).toObject(r4).orderBy(r6).limit(r7).execute();
    }

    public List<T> getAllObjects(Field<T>[] r2, Expression r3, OrderingTerm r4, long r5) throws WCDBException {
        return prepareSelect().select(r2).where(r3).orderBy(r4).limit(r5).allObjects();
    }

    public <R extends T> R getFirstObject(Field<T>[] r2, Expression r3, OrderingTerm r4, Class<R> r5) throws WCDBException {
        return (R) prepareSelect().select(r2).where(r3).orderBy(r4).firstObject(r5);
    }

    public void updateObject(T r2, Field<T>[] r3, OrderingTerm r4, long r5) throws WCDBException {
        prepareUpdate().set(r3).toObject(r2).orderBy(r4).limit(r5).execute();
    }

    public List<T> getAllObjects(Field<T>[] r2, OrderingTerm r3, long r4, long r6) throws WCDBException {
        return prepareSelect().select(r2).orderBy(r3).limit(r4).offset(r6).allObjects();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r2, Expression r3, OrderingTerm r4, Class<R> r5) throws WCDBException {
        return prepareSelect().select(r2).where(r3).orderBy(r4).allObjects(r5);
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r2, OrderingTerm r3, long r4, Class<R> r6) throws WCDBException {
        return prepareSelect().select(r2).orderBy(r3).limit(r4).allObjects(r6);
    }

    public <R extends T> List<R> getAllObjects(Expression r3, OrderingTerm r4, long r5, long r7, Class<R> r9) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r3).orderBy(r4).limit(r5).offset(r7).allObjects(r9);
    }

    public <R extends T> R getFirstObject(Field<T>[] r2, Expression r3, OrderingTerm r4, long r5, Class<R> r7) throws WCDBException {
        return (R) prepareSelect().select(r2).where(r3).orderBy(r4).limit(1).offset(r5).firstObject(r7);
    }

    public void updateObject(T r3, Expression r4, OrderingTerm r5, long r6, long r8) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r3).where(r4).orderBy(r5).limit(r6).offset(r8).execute();
    }

    public List<T> getAllObjects(Field<T>[] r2, Expression r3, OrderingTerm r4, long r5, long r7) throws WCDBException {
        return prepareSelect().select(r2).where(r3).orderBy(r4).limit(r5).offset(r7).allObjects();
    }

    public void updateObject(T r4, Field<T> r5, Expression r6, OrderingTerm r7, long r8) throws WCDBException {
        prepareUpdate().set(new Field[]{r5}).toObject(r4).where(r6).orderBy(r7).limit(r8).execute();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r2, Expression r3, OrderingTerm r4, long r5, Class<R> r7) throws WCDBException {
        return prepareSelect().select(r2).where(r3).orderBy(r4).limit(r5).allObjects(r7);
    }

    public void updateObject(T r4, Field<T> r5, OrderingTerm r6, long r7, long r9) throws WCDBException {
        prepareUpdate().set(new Field[]{r5}).toObject(r4).orderBy(r6).limit(r7).offset(r9).execute();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r2, OrderingTerm r3, long r4, long r6, Class<R> r8) throws WCDBException {
        return prepareSelect().select(r2).orderBy(r3).limit(r4).offset(r6).allObjects(r8);
    }

    public void updateObject(T r2, Field<T>[] r3, Expression r4, OrderingTerm r5, long r6) throws WCDBException {
        prepareUpdate().set(r3).toObject(r2).where(r4).orderBy(r5).limit(r6).execute();
    }

    public void updateObject(T r2, Field<T>[] r3, OrderingTerm r4, long r5, long r7) throws WCDBException {
        prepareUpdate().set(r3).toObject(r2).orderBy(r4).limit(r5).offset(r7).execute();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r2, Expression r3, OrderingTerm r4, long r5, long r7, Class<R> r9) throws WCDBException {
        return prepareSelect().select(r2).where(r3).orderBy(r4).limit(r5).offset(r7).allObjects(r9);
    }

    public void updateObject(T r4, Field<T> r5, Expression r6, OrderingTerm r7, long r8, long r10) throws WCDBException {
        prepareUpdate().set(new Field[]{r5}).toObject(r4).where(r6).orderBy(r7).limit(r8).offset(r10).execute();
    }

    public void updateObject(T r2, Field<T>[] r3, Expression r4, OrderingTerm r5, long r6, long r8) throws WCDBException {
        prepareUpdate().set(r3).toObject(r2).where(r4).orderBy(r5).limit(r6).offset(r8).execute();
    }
}
