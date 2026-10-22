package com.zte.miboard.cards.common;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.m;
import com.zte.miboard.cards.travel.b;

/* JADX INFO: loaded from: classes3.dex */
public class CustomProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f16227a = null;

    static {
        f16227a = Uri.parse("content://com.zte.miboard.cards.customprovider/sharedpref");
    }

    public CustomProvider() {
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String r5, @Nullable String r10, @Nullable Bundle r11) {
        m.i("CustomProvider", "call method= " + r5);
        r5.getClass();
        if (r5.equals("on_travel_data_changed") == true) goto L7;
        return null;
    L7:
        return b.a(getContext(), r11);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r5, @Nullable String r10, @Nullable String[] r11) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri r5, @Nullable ContentValues r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri r5, @Nullable String[] r10, @Nullable String r11, @Nullable String[] r12, @Nullable String r13) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r5, @Nullable ContentValues r10, @Nullable String r11, @Nullable String[] r12) {
        return 0;
    }
}
