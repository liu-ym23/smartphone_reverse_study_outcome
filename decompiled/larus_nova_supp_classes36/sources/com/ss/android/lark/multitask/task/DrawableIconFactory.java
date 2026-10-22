package com.ss.android.lark.multitask.task;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class DrawableIconFactory implements Task.IconFactory {
    public static final Parcelable.Creator<DrawableIconFactory> CREATOR = null;
    private static final String TAG = "MULTITASK-DrawableIconFactory";
    private final int id;
    private String name;

    public class a implements Parcelable.Creator<DrawableIconFactory> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DrawableIconFactory createFromParcel(Parcel r2) {
            return new DrawableIconFactory(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DrawableIconFactory[] newArray(int r1) {
            return new DrawableIconFactory[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "DrawableIconFactory{id=" + this.id + ", name='" + this.name + "'}";
    }

    public String getName() {
        return this.name;
    }

    public String saveArgs() {
        return this.name;
    }

    public DrawableIconFactory(Parcel r2) {
        this.id = r2.readInt();
        this.name = r2.readString();
    }

    public DrawableIconFactory(int r2) {
        this(r2, null);
    }

    public DrawableIconFactory(String r2) {
        this(0, r2);
    }

    public DrawableIconFactory(int r1, String r2) {
        this.id = r1;
        this.name = r2;
    }

    public Drawable createDrawableForTask(Context r4, d r5) {
        if (this.name != null) goto L11;
        return ContextCompat.getDrawable(r4, this.id);
    L11:
        return ContextCompat.getDrawable(r4, r4.getResources().getIdentifier(this.name, "drawable", r4.getPackageName()));
    L9:
        Log.w(TAG, "createDrawableForTask failed, name = " + this.name);
        return new ColorDrawable(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.id);
        r1.writeString(this.name);
    }

    public void createDrawableForTask(Context r1, d r2, ImageView r3) {
        r3.setImageDrawable(createDrawableForTask(r1, r2));
    }
}
