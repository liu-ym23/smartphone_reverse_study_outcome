package com.bytedance.ai.resource.core.db;

import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.widgets.d;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import w2.g;

/* JADX INFO: loaded from: classes2.dex */
public final class AIPackageDao_Impl extends AIPackageDao {
    private final g __dataConverter;
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<Applet> __deletionAdapterOfApplet;
    private final EntityDeletionOrUpdateAdapter<Widget> __deletionAdapterOfWidget;
    private final EntityInsertionAdapter<Applet> __insertionAdapterOfApplet;
    private final EntityInsertionAdapter<Widget> __insertionAdapterOfWidget;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAppletById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAppletByPackageName;
    private final SharedSQLiteStatement __preparedStmtOfDeleteWidgetById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteWidgetByPackageName;
    private final SharedSQLiteStatement __preparedStmtOfMarkAppletToDelete;
    private final SharedSQLiteStatement __preparedStmtOfMarkWidgetToDelete;
    private final EntityDeletionOrUpdateAdapter<Applet> __updateAdapterOfApplet;
    private final EntityDeletionOrUpdateAdapter<Widget> __updateAdapterOfWidget;

    public AIPackageDao_Impl(final RoomDatabase r5) {
        this.__dataConverter = new g();
        this.__db = r5;
        this.__insertionAdapterOfWidget = new AnonymousClass1(this, r5);
        this.__insertionAdapterOfApplet = new AnonymousClass2(this, r5);
        this.__deletionAdapterOfWidget = new AnonymousClass3(this, r5);
        this.__deletionAdapterOfApplet = new AnonymousClass4(this, r5);
        this.__updateAdapterOfWidget = new AnonymousClass5(this, r5);
        this.__updateAdapterOfApplet = new AnonymousClass6(this, r5);
        this.__preparedStmtOfDeleteWidgetById = new AnonymousClass7(this, r5);
        this.__preparedStmtOfDeleteWidgetByPackageName = new AnonymousClass8(this, r5);
        this.__preparedStmtOfMarkWidgetToDelete = new AnonymousClass9(this, r5);
        this.__preparedStmtOfDeleteAppletById = new AnonymousClass10(this, r5);
        this.__preparedStmtOfDeleteAppletByPackageName = new AnonymousClass11(this, r5);
        this.__preparedStmtOfMarkAppletToDelete = new AnonymousClass12(this, r5);
    }

    public static /* synthetic */ Object a(AIPackageDao_Impl r5, String r10, String r11, long r12, Continuation r13) {
        return r5.lambda$queryOrActiveWidget$0(r10, r11, r12, r13);
    }

    public static /* synthetic */ g access$000(AIPackageDao_Impl r5) {
        return r5.__dataConverter;
    }

    public static /* synthetic */ RoomDatabase access$100(AIPackageDao_Impl r5) {
        return r5.__db;
    }

    public static /* synthetic */ SharedSQLiteStatement access$1000(AIPackageDao_Impl r5) {
        return r5.__preparedStmtOfMarkWidgetToDelete;
    }

    public static /* synthetic */ SharedSQLiteStatement access$1100(AIPackageDao_Impl r5) {
        return r5.__preparedStmtOfDeleteAppletById;
    }

    public static /* synthetic */ SharedSQLiteStatement access$1200(AIPackageDao_Impl r5) {
        return r5.__preparedStmtOfDeleteAppletByPackageName;
    }

    public static /* synthetic */ SharedSQLiteStatement access$1300(AIPackageDao_Impl r5) {
        return r5.__preparedStmtOfMarkAppletToDelete;
    }

    public static /* synthetic */ Object access$1401(AIPackageDao_Impl r5, Applet r10, Continuation r11) {
        return super.insertInactiveApplet(r10, r11);
    }

    public static /* synthetic */ Object access$1501(AIPackageDao_Impl r5, Widget r10, Continuation r11) {
        return super.insertInactiveWidget(r10, r11);
    }

    public static /* synthetic */ Object access$1601(AIPackageDao_Impl r5, String r10, String r11, long r12, Continuation r13) {
        return super.queryOrActiveApplet(r10, r11, r12, r13);
    }

    public static /* synthetic */ Object access$1701(AIPackageDao_Impl r5, String r10, String r11, long r12, Continuation r13) {
        return super.queryOrActiveWidget(r10, r11, r12, r13);
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(AIPackageDao_Impl r5) {
        return r5.__insertionAdapterOfWidget;
    }

    public static /* synthetic */ EntityInsertionAdapter access$300(AIPackageDao_Impl r5) {
        return r5.__insertionAdapterOfApplet;
    }

    public static /* synthetic */ EntityDeletionOrUpdateAdapter access$400(AIPackageDao_Impl r5) {
        return r5.__deletionAdapterOfWidget;
    }

    public static /* synthetic */ EntityDeletionOrUpdateAdapter access$500(AIPackageDao_Impl r5) {
        return r5.__deletionAdapterOfApplet;
    }

    public static /* synthetic */ EntityDeletionOrUpdateAdapter access$600(AIPackageDao_Impl r5) {
        return r5.__updateAdapterOfWidget;
    }

    public static /* synthetic */ EntityDeletionOrUpdateAdapter access$700(AIPackageDao_Impl r5) {
        return r5.__updateAdapterOfApplet;
    }

    public static /* synthetic */ SharedSQLiteStatement access$800(AIPackageDao_Impl r5) {
        return r5.__preparedStmtOfDeleteWidgetById;
    }

    public static /* synthetic */ SharedSQLiteStatement access$900(AIPackageDao_Impl r5) {
        return r5.__preparedStmtOfDeleteWidgetByPackageName;
    }

    public static /* synthetic */ Object b(AIPackageDao_Impl r5, Widget r10, Continuation r11) {
        return r5.lambda$insertInactiveWidget$2(r10, r11);
    }

    public static /* synthetic */ Object c(AIPackageDao_Impl r5, String r10, String r11, long r12, Continuation r13) {
        return r5.lambda$queryOrActiveApplet$1(r10, r11, r12, r13);
    }

    public static /* synthetic */ Object d(AIPackageDao_Impl r5, Applet r10, Continuation r11) {
        return r5.lambda$insertInactiveApplet$3(r10, r11);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    private /* synthetic */ Object lambda$insertInactiveApplet$3(Applet r5, Continuation r10) {
        return access$1401(this, r5, r10);
    }

    private /* synthetic */ Object lambda$insertInactiveWidget$2(Widget r5, Continuation r10) {
        return access$1501(this, r5, r10);
    }

    private /* synthetic */ Object lambda$queryOrActiveApplet$1(String r5, String r10, long r11, Continuation r12) {
        return access$1601(this, r5, r10, r11, r12);
    }

    private /* synthetic */ Object lambda$queryOrActiveWidget$0(String r5, String r10, long r11, Continuation r12) {
        return access$1701(this, r5, r10, r11, r12);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object deleteApplet(final Applet r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass17(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object deleteAppletById(final String r5, final String r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass24(this, r5, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object deleteAppletByPackageName(final String r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass25(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object deleteApplets(final List<Applet> r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass18(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object deleteWidget(final Widget r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass15(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object deleteWidgetById(final String r5, final String r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass21(this, r5, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object deleteWidgetByPackageName(final String r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass22(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object deleteWidgets(final List<? extends Widget> r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass16(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object insertApplet(final Applet r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass14(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object insertInactiveApplet(Applet r5, Continuation<? super Unit> r10) {
        return RoomDatabaseKt.withTransaction(this.__db, new d(5, this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object insertInactiveWidget(Widget r5, Continuation<? super Unit> r10) {
        return RoomDatabaseKt.withTransaction(this.__db, new d(6, this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object insertWidget(final Widget r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass13(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object markAppletToDelete(final String r5, final String r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass26(this, r5, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object markWidgetToDelete(final String r5, final String r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass23(this, r5, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryAllApplets(Continuation<? super List<Applet>> r10) {
        final RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r11, new AnonymousClass41(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryAllWidgets(Continuation<? super List<? extends Widget>> r10) {
        final RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r11, new AnonymousClass31(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryAppletByBotId(String r5, Continuation<? super List<Applet>> r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'installed' AND bot_id = ?", 1);
        if (r5 != null) goto L5;
        r11.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r12, new AnonymousClass46(this, r11), r10);
    L5:
        r11.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryAppletById(String r5, String r10, Continuation<? super List<Applet>> r11) {
        final RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? ORDER BY ut DESC", 2);
        if (r5 != null) goto L5;
        r12.bindNull(1);
    L6:
        if (r10 != null) goto L8;
        r12.bindNull(2);
    L9:
        CancellationSignal r13 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r13, new AnonymousClass37(this, r12), r11);
    L8:
        r12.bindString(2, r10);
        goto L9
    L5:
        r12.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryAppletsToDelete(Continuation<? super List<Applet>> r10) {
        final RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE ready_for_deleting = 1", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r11, new AnonymousClass47(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInactiveApplets(Continuation<? super List<Applet>> r10) {
        final RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'inactive'", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r11, new AnonymousClass42(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInactiveWidgets(Continuation<? super List<? extends Widget>> r10) {
        final RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE status = 'inactive'", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r11, new AnonymousClass32(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInstalledApplets(Continuation<? super List<Applet>> r10) {
        final RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'installed' AND ready_for_deleting = 0", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r11, new AnonymousClass44(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInstalledAppletsByPackageName(String r5, Continuation<? super List<Applet>> r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0", 1);
        if (r5 != null) goto L5;
        r11.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r12, new AnonymousClass40(this, r11), r10);
    L5:
        r11.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInstalledWidgets(Continuation<? super List<? extends Widget>> r10) {
        final RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE status = 'installed' AND ready_for_deleting = 0", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r11, new AnonymousClass34(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInstalledWidgetsByPackageName(String r5, Continuation<? super List<? extends Widget>> r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0", 1);
        if (r5 != null) goto L5;
        r11.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r12, new AnonymousClass30(this, r11), r10);
    L5:
        r11.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryOrActiveApplet(String r10, String r11, long r12, Continuation<? super Applet> r14) {
        return RoomDatabaseKt.withTransaction(this.__db, new a(this, r10, r11, r12, 0), r14);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryOrActiveWidget(String r10, String r11, long r12, Continuation<? super Widget> r14) {
        return RoomDatabaseKt.withTransaction(this.__db, new a(this, r10, r11, r12, 1), r14);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryWidgetById(String r5, String r10, Continuation<? super List<? extends Widget>> r11) {
        final RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? ORDER BY ut DESC", 2);
        if (r5 != null) goto L5;
        r12.bindNull(1);
    L6:
        if (r10 != null) goto L8;
        r12.bindNull(2);
    L9:
        CancellationSignal r13 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r13, new AnonymousClass27(this, r12), r11);
    L8:
        r12.bindString(2, r10);
        goto L9
    L5:
        r12.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryWidgetsToDelete(Continuation<? super List<? extends Widget>> r10) {
        final RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE ready_for_deleting = 1", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r11, new AnonymousClass36(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object updateApplet(final Applet[] r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass20(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object updateWidget(final Widget[] r5, Continuation<? super Unit> r10) {
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass19(this, r5), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInactiveApplets(String r5, Continuation<? super List<Applet>> r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'inactive' AND ready_for_deleting = 0", 1);
        if (r5 != null) goto L5;
        r11.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r12, new AnonymousClass43(this, r11), r10);
    L5:
        r11.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInactiveWidgets(String r5, Continuation<? super List<? extends Widget>> r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'inactive' AND ready_for_deleting = 0", 1);
        if (r5 != null) goto L5;
        r11.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r12, new AnonymousClass33(this, r11), r10);
    L5:
        r11.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInstalledApplets(String r5, long r10, Continuation<? super List<Applet>> r11) {
        final RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0 AND version_code = ?", 2);
        if (r5 != null) goto L5;
        r12.bindNull(1);
    L6:
        r12.bindLong(2, r10);
        CancellationSignal r13 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r13, new AnonymousClass45(this, r12), r11);
    L5:
        r12.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryInstalledWidgets(String r5, long r10, Continuation<? super List<? extends Widget>> r11) {
        final RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0 AND version_code = ?", 2);
        if (r5 != null) goto L5;
        r12.bindNull(1);
    L6:
        r12.bindLong(2, r10);
        CancellationSignal r13 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r13, new AnonymousClass35(this, r12), r11);
    L5:
        r12.bindString(1, r5);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryAppletById(String r5, String r10, String r11, Continuation<? super List<Applet>> r12) {
        final RoomSQLiteQuery r13 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? AND status = ? ORDER BY ut DESC", 3);
        if (r5 != null) goto L5;
        r13.bindNull(1);
    L7:
        if (r10 != null) goto L9;
        r13.bindNull(2);
    L10:
        if (r11 != null) goto L12;
        r13.bindNull(3);
    L13:
        CancellationSignal r14 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r14, new AnonymousClass38(this, r13), r12);
    L12:
        r13.bindString(3, r11);
        goto L13
    L9:
        r13.bindString(2, r10);
        goto L10
    L5:
        r13.bindString(1, r5);
        goto L7
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryWidgetById(String r5, String r10, String r11, Continuation<? super List<? extends Widget>> r12) {
        final RoomSQLiteQuery r13 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? AND status = ? ORDER BY ut DESC", 3);
        if (r5 != null) goto L5;
        r13.bindNull(1);
    L7:
        if (r10 != null) goto L9;
        r13.bindNull(2);
    L10:
        if (r11 != null) goto L12;
        r13.bindNull(3);
    L13:
        CancellationSignal r14 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r14, new AnonymousClass28(this, r13), r12);
    L12:
        r13.bindString(3, r11);
        goto L13
    L9:
        r13.bindString(2, r10);
        goto L10
    L5:
        r13.bindString(1, r5);
        goto L7
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryAppletById(String r5, String r10, String r11, long r12, Continuation<? super Applet> r13) {
        final RoomSQLiteQuery r14 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? AND status = ? AND version_code = ?", 4);
        if (r5 != null) goto L5;
        r14.bindNull(1);
    L7:
        if (r10 != null) goto L9;
        r14.bindNull(2);
    L11:
        if (r11 != null) goto L13;
        r14.bindNull(3);
    L14:
        r14.bindLong(4, r12);
        CancellationSignal r15 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r15, new AnonymousClass39(this, r14), r13);
    L13:
        r14.bindString(3, r11);
        goto L14
    L9:
        r14.bindString(2, r10);
        goto L11
    L5:
        r14.bindString(1, r5);
        goto L7
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public Object queryWidgetById(String r5, String r10, String r11, long r12, Continuation<? super Widget> r13) {
        final RoomSQLiteQuery r14 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? AND status = ? AND version_code = ?", 4);
        if (r5 != null) goto L5;
        r14.bindNull(1);
    L7:
        if (r10 != null) goto L9;
        r14.bindNull(2);
    L11:
        if (r11 != null) goto L13;
        r14.bindNull(3);
    L14:
        r14.bindLong(4, r12);
        CancellationSignal r15 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r15, new AnonymousClass29(this, r14), r13);
    L13:
        r14.bindString(3, r11);
        goto L14
    L9:
        r14.bindString(2, r10);
        goto L11
    L5:
        r14.bindString(1, r5);
        goto L7
    }
}
