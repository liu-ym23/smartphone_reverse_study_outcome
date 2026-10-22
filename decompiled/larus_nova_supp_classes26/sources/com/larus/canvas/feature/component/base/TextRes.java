package com.larus.canvas.feature.component.base;

import android.content.Context;
import android.content.res.Resources;
import com.larus.common.apphost.AppHost;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/larus/canvas/feature/component/base/TextRes;", "Ljava/io/Serializable;", "<init>", "()V", "toString", "", "context", "Landroid/content/Context;", "PlainText", "StringResId", "Lcom/larus/canvas/feature/component/base/TextRes$PlainText;", "Lcom/larus/canvas/feature/component/base/TextRes$StringResId;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TextRes implements Serializable {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0006\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/canvas/feature/component/base/TextRes$PlainText;", "Lcom/larus/canvas/feature/component/base/TextRes;", "string", "", "<init>", "(Ljava/lang/String;)V", "toString", "context", "Landroid/content/Context;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PlainText extends TextRes {
        public final String string;

        public static /* synthetic */ PlainText copy$default(PlainText r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.string;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.string;
        }

        public final PlainText copy(String r2) {
            Intrinsics.checkNotNullParameter(r2, "string");
            return new PlainText(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof PlainText) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.string, ((PlainText) r4).string) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.string.hashCode();
        }

        public String toString() {
            return "PlainText(string=" + this.string + ')';
        }

        public PlainText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "string");
            super(null);
            this.string = r2;
        }

        @Override // com.larus.canvas.feature.component.base.TextRes
        public String toString(Context r1) {
            return this.string;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0006\u001a\u00020\u0007HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/canvas/feature/component/base/TextRes$StringResId;", "Lcom/larus/canvas/feature/component/base/TextRes;", "resId", "", "<init>", "(I)V", "toString", "", "context", "Landroid/content/Context;", "component1", "copy", "equals", "", "other", "", "hashCode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StringResId extends TextRes {
        public final int resId;

        public static /* synthetic */ StringResId copy$default(StringResId r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.resId;
        L6:
            return r0.copy(r1);
        }

        public final int component1() {
            return this.resId;
        }

        public final StringResId copy(int r2) {
            return new StringResId(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof StringResId) == true) goto L9;
            return false;
        L9:
            if (this.resId == ((StringResId) r4).resId) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.resId;
        }

        public String toString() {
            return "StringResId(resId=" + this.resId + ')';
        }

        public StringResId(int r2) {
            super(null);
            this.resId = r2;
        }

        @Override // com.larus.canvas.feature.component.base.TextRes
        public String toString(Context r2) {
            if (r2 == null) goto L8;
            Resources r3 = r2.getResources();
            if (r3 == null) goto L8;
            String r4 = r3.getString(this.resId);
            if (r4 == null) goto L8;
            return r4;
        L8:
            return AppHost.a.getApplication().getString(this.resId);
        }
    }

    private TextRes() {
    }

    public /* synthetic */ TextRes(DefaultConstructorMarker r1) {
        this();
    }

    public abstract String toString(Context r1);
}
