package com.obric.flow.cardlistpage.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Database(entities = {j.class, sk.a.class}, exportSchema = true, version = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/flow/cardlistpage/data/CardDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class CardDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CardDatabase$Companion$MIGRATION_1_2$1 f11465a = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.flow.cardlistpage.data.CardDatabase$Companion$MIGRATION_1_2$1] */
    static {
        f11465a = new CardDatabase$Companion$MIGRATION_1_2$1();
    }

    public CardDatabase() {
    }

    public abstract a a();
}
