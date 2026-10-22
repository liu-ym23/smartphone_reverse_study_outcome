package com.obric.flow.cardlistpage.data;

import androidx.room.CoroutinesRoom;
import androidx.room.RoomSQLiteQuery;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardDatabase_Impl f11479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f11480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f11481c;
    public final f d;
    public final f e;
    public final f f;

    public h(CardDatabase_Impl r5) {
        this.f11479a = r5;
        this.f11480b = new d(r5);
        new e(r5, 0);
        this.f11481c = new e(r5, 1);
        this.d = new f(r5, 0);
        this.e = new f(r5, 1);
        this.f = new f(r5, 2);
    }

    @Override // com.obric.flow.cardlistpage.data.a
    public final kotlinx.coroutines.flow.g b(String r5) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT * FROM cards WHERE type = ? ORDER BY `sortIndex` ASC", 1);
        r10.bindString(1, r5);
        c r11 = new c(this, r10, 1);
        CardDatabase_Impl r12 = this.f11479a;
        return CoroutinesRoom.createFlow(r12, false, new String[]{"cards"}, r11);
    }
}
