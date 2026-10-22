package com.bytedance.ai.applet.app.foundation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "Landroid/os/Parcelable;", "<init>", "()V", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "Launch", "NavigateTo", "RedirectTo", "ReLaunch", "OpenPage", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$Launch;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$NavigateTo;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$OpenPage;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$ReLaunch;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$RedirectTo;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RouteAction implements Parcelable {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$Launch;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Launch extends RouteAction {
        public static final Parcelable.Creator<Launch> CREATOR = null;
        public final RouteOptions a;

        public static final class a implements Parcelable.Creator<Launch> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Launch createFromParcel(Parcel r10) {
                Intrinsics.checkNotNullParameter(r10, "parcel");
                if (r10.readInt() != 0) goto L5;
                RouteOptions r11 = null;
            L7:
                return new Launch(r11);
            L5:
                r11 = RouteOptions.CREATOR.createFromParcel(r10);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final Launch[] newArray(int r1) {
                return new Launch[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public Launch() {
            this(null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Launch) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((Launch) r10).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            RouteOptions r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Launch(options=" + this.a + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "dest");
            RouteOptions r0 = this.a;
            if (r0 != null) goto L5;
            r10.writeInt(0);
            return;
        L5:
            r10.writeInt(1);
            r0.writeToParcel(r10, r11);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.a;
        }

        public Launch(RouteOptions r1) {
            this.a = r1;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$NavigateTo;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", com.bytedance.android.ec.core.event.a.KEY_URL, "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getUrl", "()Ljava/lang/String;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NavigateTo extends RouteAction {
        public static final Parcelable.Creator<NavigateTo> CREATOR = null;
        public final String a;
        public final RouteOptions b;

        public static final class a implements Parcelable.Creator<NavigateTo> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final NavigateTo createFromParcel(Parcel r10) {
                Intrinsics.checkNotNullParameter(r10, "parcel");
                String r1 = r10.readString();
                if (r10.readInt() != 0) goto L5;
                RouteOptions r11 = null;
            L7:
                return new NavigateTo(r1, r11);
            L5:
                r11 = RouteOptions.CREATOR.createFromParcel(r10);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final NavigateTo[] newArray(int r1) {
                return new NavigateTo[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof NavigateTo) == true) goto L8;
            return false;
        L8:
            NavigateTo r11 = (NavigateTo) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            RouteOptions r1 = this.b;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return r0 + r10;
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "NavigateTo(url=" + this.a + ", options=" + this.b + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "dest");
            r10.writeString(this.a);
            RouteOptions r0 = this.b;
            if (r0 != null) goto L5;
            r10.writeInt(0);
            return;
        L5:
            r10.writeInt(1);
            r0.writeToParcel(r10, r11);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.b;
        }

        public NavigateTo(String r10, RouteOptions r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a = r10;
            this.b = r11;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$OpenPage;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", com.bytedance.android.ec.core.event.a.KEY_URL, "", "mode", "Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getUrl", "()Ljava/lang/String;", "getMode", "()Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenPage extends RouteAction {
        public static final Parcelable.Creator<OpenPage> CREATOR = null;
        public final String a;
        public final ApplicationRouter.OpenPageMode b;
        public final RouteOptions c;

        public static final class a implements Parcelable.Creator<OpenPage> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OpenPage createFromParcel(Parcel r10) {
                Intrinsics.checkNotNullParameter(r10, "parcel");
                String r1 = r10.readString();
                ApplicationRouter.OpenPageMode r11 = ApplicationRouter.OpenPageMode.valueOf(r10.readString());
                if (r10.readInt() != 0) goto L5;
                RouteOptions r12 = null;
            L7:
                return new OpenPage(r1, r11, r12);
            L5:
                r12 = RouteOptions.CREATOR.createFromParcel(r10);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final OpenPage[] newArray(int r1) {
                return new OpenPage[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof OpenPage) == true) goto L8;
            return false;
        L8:
            OpenPage r11 = (OpenPage) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            RouteOptions r1 = this.c;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return r0 + r10;
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "OpenPage(url=" + this.a + ", mode=" + this.b + ", options=" + this.c + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "dest");
            r10.writeString(this.a);
            r10.writeString(this.b.name());
            RouteOptions r0 = this.c;
            if (r0 != null) goto L5;
            r10.writeInt(0);
            return;
        L5:
            r10.writeInt(1);
            r0.writeToParcel(r10, r11);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.c;
        }

        public OpenPage(String r10, ApplicationRouter.OpenPageMode r11, RouteOptions r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r11, "mode");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$ReLaunch;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", com.bytedance.android.ec.core.event.a.KEY_URL, "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getUrl", "()Ljava/lang/String;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReLaunch extends RouteAction {
        public static final Parcelable.Creator<ReLaunch> CREATOR = null;
        public final String a;
        public final RouteOptions b;

        public static final class a implements Parcelable.Creator<ReLaunch> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ReLaunch createFromParcel(Parcel r10) {
                Intrinsics.checkNotNullParameter(r10, "parcel");
                String r1 = r10.readString();
                if (r10.readInt() != 0) goto L5;
                RouteOptions r11 = null;
            L7:
                return new ReLaunch(r1, r11);
            L5:
                r11 = RouteOptions.CREATOR.createFromParcel(r10);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final ReLaunch[] newArray(int r1) {
                return new ReLaunch[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ReLaunch) == true) goto L8;
            return false;
        L8:
            ReLaunch r11 = (ReLaunch) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            RouteOptions r1 = this.b;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return r0 + r10;
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ReLaunch(url=" + this.a + ", options=" + this.b + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "dest");
            r10.writeString(this.a);
            RouteOptions r0 = this.b;
            if (r0 != null) goto L5;
            r10.writeInt(0);
            return;
        L5:
            r10.writeInt(1);
            r0.writeToParcel(r10, r11);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.b;
        }

        public ReLaunch(String r10, RouteOptions r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a = r10;
            this.b = r11;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$RedirectTo;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", com.bytedance.android.ec.core.event.a.KEY_URL, "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getUrl", "()Ljava/lang/String;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RedirectTo extends RouteAction {
        public static final Parcelable.Creator<RedirectTo> CREATOR = null;
        public final String a;
        public final RouteOptions b;

        public static final class a implements Parcelable.Creator<RedirectTo> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final RedirectTo createFromParcel(Parcel r10) {
                Intrinsics.checkNotNullParameter(r10, "parcel");
                String r1 = r10.readString();
                if (r10.readInt() != 0) goto L5;
                RouteOptions r11 = null;
            L7:
                return new RedirectTo(r1, r11);
            L5:
                r11 = RouteOptions.CREATOR.createFromParcel(r10);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final RedirectTo[] newArray(int r1) {
                return new RedirectTo[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof RedirectTo) == true) goto L8;
            return false;
        L8:
            RedirectTo r11 = (RedirectTo) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            RouteOptions r1 = this.b;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return r0 + r10;
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "RedirectTo(url=" + this.a + ", options=" + this.b + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "dest");
            r10.writeString(this.a);
            RouteOptions r0 = this.b;
            if (r0 != null) goto L5;
            r10.writeInt(0);
            return;
        L5:
            r10.writeInt(1);
            r0.writeToParcel(r10, r11);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.b;
        }

        public RedirectTo(String r10, RouteOptions r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a = r10;
            this.b = r11;
        }
    }

    public RouteAction() {
    }

    public RouteOptions a() {
        return null;
    }
}
