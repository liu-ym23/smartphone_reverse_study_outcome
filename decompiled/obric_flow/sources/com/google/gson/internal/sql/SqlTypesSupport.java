package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SqlTypesSupport {
    public static final DefaultDateTypeAdapter.DateType<? extends Date> DATE_DATE_TYPE = null;
    public static final TypeAdapterFactory DATE_FACTORY = null;
    public static final List<TypeAdapterFactory> SQL_TYPE_FACTORIES = null;
    public static final boolean SUPPORTS_SQL_TYPES = false;
    public static final DefaultDateTypeAdapter.DateType<? extends Date> TIMESTAMP_DATE_TYPE = null;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY = null;
    public static final TypeAdapterFactory TIME_FACTORY = null;

    static {
        Class.forName("java.sql.Date");     // Catch: ClassNotFoundException -> L5
        boolean r5 = true;
    L6:
        SUPPORTS_SQL_TYPES = r5;
        if (r5 == false) goto L9;
        final Class<java.sql.Date> r10 = java.sql.Date.class;
        DATE_DATE_TYPE = new AnonymousClass1(r10);
        final Class<Timestamp> r11 = Timestamp.class;
        TIMESTAMP_DATE_TYPE = new AnonymousClass2(r11);
        TypeAdapterFactory r12 = SqlDateTypeAdapter.FACTORY;
        DATE_FACTORY = r12;
        TypeAdapterFactory r13 = SqlTimeTypeAdapter.FACTORY;
        TIME_FACTORY = r13;
        TypeAdapterFactory r14 = SqlTimestampTypeAdapter.FACTORY;
        TIMESTAMP_FACTORY = r14;
        SQL_TYPE_FACTORIES = Collections.unmodifiableList(Arrays.asList(new TypeAdapterFactory[]{r13, r12, r14}));
        return;
    L9:
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
        SQL_TYPE_FACTORIES = Collections.emptyList();
        return;
    L5:
        r5 = false;
        goto L6
    }

    private SqlTypesSupport() {
    }
}
