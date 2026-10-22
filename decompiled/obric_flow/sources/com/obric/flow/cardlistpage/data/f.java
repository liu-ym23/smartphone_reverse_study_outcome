package com.obric.flow.cardlistpage.data;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends SharedSQLiteStatement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11475a;

    public /* synthetic */ f(RoomDatabase r5, int r10) {
        this.f11475a = r10;
        super(r5);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch(this.f11475a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return "UPDATE id_sequence SET nextValue = ? WHERE name = ?";
    L6:
        return "INSERT OR IGNORE INTO id_sequence(name, nextValue) VALUES(?, ?)";
    L8:
        return "DELETE FROM cards WHERE id = ?";
    }
}
