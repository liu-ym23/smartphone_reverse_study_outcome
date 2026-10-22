package com.ss.ugc.effectplatform.model;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/ss/ugc/effectplatform/model/CheckUpdateVersionModel;", "", EffectConfiguration.KEY_VERSION, "", EffectConfiguration.KEY_CURSOR, EffectConfiguration.KEY_SORTING_POSITION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCursor", "()Ljava/lang/String;", "setCursor", "(Ljava/lang/String;)V", "getSorting_position", "setSorting_position", "getVersion", "setVersion", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class CheckUpdateVersionModel {
    private String cursor;
    private String sorting_position;
    private String version;

    public CheckUpdateVersionModel() {
        this(null, null, null, 7, null);
    }

    public String getCursor() {
        return this.cursor;
    }

    public String getSorting_position() {
        return this.sorting_position;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCursor(String r1) {
        this.cursor = r1;
    }

    public void setSorting_position(String r1) {
        this.sorting_position = r1;
    }

    public void setVersion(String r1) {
        this.version = r1;
    }

    public CheckUpdateVersionModel(String r1, String r2, String r3) {
        this.version = r1;
        this.cursor = r2;
        this.sorting_position = r3;
    }

    public /* synthetic */ CheckUpdateVersionModel(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
