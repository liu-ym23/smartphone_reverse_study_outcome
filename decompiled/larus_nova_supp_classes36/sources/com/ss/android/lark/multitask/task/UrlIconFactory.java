package com.ss.android.lark.multitask.task;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u000b\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0003J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/multitask/task/UrlIconFactory;", "Lcom/ss/android/lark/multitask/task/Task$IconFactory;", "url", "", "<init>", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getUrl", "()Ljava/lang/String;", "createDrawableForTask", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "task", "Lcom/ss/android/lark/multitask/task/TaskSnapshot;", "", "imageView", "Landroid/widget/ImageView;", "saveArgs", "writeToParcel", "flags", "", "describeContents", "CREATOR", "multitask_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UrlIconFactory implements Task.IconFactory {
    public static final a CREATOR = null;
    private final String url;

    public static final class a implements Parcelable.Creator<UrlIconFactory> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UrlIconFactory createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new UrlIconFactory(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final UrlIconFactory[] newArray(int r1) {
            return new UrlIconFactory[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String saveArgs() {
        return this.url;
    }

    public UrlIconFactory(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        String r3 = r2.readString();
        Intrinsics.checkNotNull(r3);
        this(r3);
    }

    public UrlIconFactory(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.url = r2;
    }

    public Drawable createDrawableForTask(Context r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "task");
        return new ColorDrawable(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.url);
    }

    public void createDrawableForTask(Context r2, d r3, ImageView r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "task");
        Intrinsics.checkNotNullParameter(r4, "imageView");
        ImageLoader.with(r2).load(this.url).asBitmap().into(r4);
    }
}
