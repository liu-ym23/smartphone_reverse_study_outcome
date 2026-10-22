package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = null;
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    private final IntentSender mIntentSender;

    public static final class Builder {
        private Intent mFillInIntent;
        private int mFlagsMask;
        private int mFlagsValues;
        private IntentSender mIntentSender;

        public Builder(PendingIntent r1) {
            this(r1.getIntentSender());
        }

        public Builder(IntentSender r1) {
            this.mIntentSender = r1;
        }

        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
        }

        public Builder setFillInIntent(Intent r1) {
            this.mFillInIntent = r1;
            return this;
        }

        public Builder setFlags(int r1, int r2) {
            this.mFlagsValues = r1;
            this.mFlagsMask = r2;
            return this;
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    IntentSenderRequest(IntentSender r1, Intent r2, int r3, int r4) {
        this.mIntentSender = r1;
        this.mFillInIntent = r2;
        this.mFlagsMask = r3;
        this.mFlagsValues = r4;
    }

    IntentSenderRequest(Parcel r4) {
        this.mIntentSender = (IntentSender) ZeusTransformUtils.preCheckCast(r4.readParcelable(IntentSender.class.getClassLoader()), IntentSender.class, "com.obric.memorydata.plugin");
        this.mFillInIntent = (Intent) ZeusTransformUtils.preCheckCast(r4.readParcelable(Intent.class.getClassLoader()), Intent.class, "com.obric.memorydata.plugin");
        this.mFlagsMask = r4.readInt();
        this.mFlagsValues = r4.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mIntentSender, r3);
        r2.writeParcelable(this.mFillInIntent, r3);
        r2.writeInt(this.mFlagsMask);
        r2.writeInt(this.mFlagsValues);
    }
}
