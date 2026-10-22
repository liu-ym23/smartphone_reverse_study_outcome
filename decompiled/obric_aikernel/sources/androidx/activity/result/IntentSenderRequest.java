package androidx.activity.result;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = null;

    @Nullable
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;

    @NonNull
    private final IntentSender mIntentSender;

    public static final class Builder {
        private Intent mFillInIntent;
        private int mFlagsMask;
        private int mFlagsValues;
        private IntentSender mIntentSender;

        public Builder(@NonNull PendingIntent r10) {
            this(r10.getIntentSender());
        }

        public Builder(@NonNull IntentSender r10) {
            this.mIntentSender = r10;
        }

        @NonNull
        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
        }

        @NonNull
        public Builder setFillInIntent(@Nullable Intent r10) {
            this.mFillInIntent = r10;
            return this;
        }

        @NonNull
        public Builder setFlags(int r10, int r11) {
            this.mFlagsValues = r10;
            this.mFlagsMask = r11;
            return this;
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    IntentSenderRequest(@NonNull IntentSender r10, @Nullable Intent r11, int r12, int r13) {
        this.mIntentSender = r10;
        this.mFillInIntent = r11;
        this.mFlagsMask = r12;
        this.mFlagsValues = r13;
    }

    IntentSenderRequest(@NonNull Parcel r10) {
        this.mIntentSender = (IntentSender) r10.readParcelable(IntentSender.class.getClassLoader());
        this.mFillInIntent = (Intent) r10.readParcelable(Intent.class.getClassLoader());
        this.mFlagsMask = r10.readInt();
        this.mFlagsValues = r10.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    @NonNull
    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeParcelable(this.mIntentSender, r11);
        r10.writeParcelable(this.mFillInIntent, r11);
        r10.writeInt(this.mFlagsMask);
        r10.writeInt(this.mFlagsValues);
    }
}
