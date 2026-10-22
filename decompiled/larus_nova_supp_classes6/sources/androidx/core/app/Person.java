package androidx.core.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    String mKey;
    CharSequence mName;
    String mUri;

    public String resolveToLegacyUri() {
        String r0 = this.mUri;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mName != null) goto L8;
        return "";
    L8:
        return "name:" + this.mName;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putCharSequence(NAME_KEY, this.mName);
        IconCompat r1 = this.mIcon;
        if (r1 == null) goto L5;
        Bundle r2 = r1.toBundle();
    L6:
        r0.putBundle(ICON_KEY, r2);
        r0.putString(URI_KEY, this.mUri);
        r0.putString(KEY_KEY, this.mKey);
        r0.putBoolean(IS_BOT_KEY, this.mIsBot);
        r0.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public int hashCode() {
        String r0 = getKey();
        if (r0 == null) goto L7;
        return r0.hashCode();
    L7:
        return Objects.hash(new Object[]{getName(), getUri(), Boolean.valueOf(isBot()), Boolean.valueOf(isImportant())});
    }

    public android.app.Person toAndroidPerson() {
        return Api28Impl.toAndroidPerson(this);
    }

    public PersistableBundle toPersistableBundle() {
        return Api22Impl.toPersistableBundle(this);
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getKey() {
        return this.mKey;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    public Person(Builder r2) {
        this.mName = r2.mName;
        this.mIcon = r2.mIcon;
        this.mUri = r2.mUri;
        this.mKey = r2.mKey;
        this.mIsBot = r2.mIsBot;
        this.mIsImportant = r2.mIsImportant;
    }

    public static Person fromAndroidPerson(android.app.Person r0) {
        return Api28Impl.fromAndroidPerson(r0);
    }

    public static Person fromBundle(Bundle r3) {
        Bundle r0 = r3.getBundle(ICON_KEY);
        Builder r1 = new Builder().setName(r3.getCharSequence(NAME_KEY));
        if (r0 == null) goto L5;
        IconCompat r2 = IconCompat.createFromBundle(r0);
    L7:
        return r1.setIcon(r2).setUri(r3.getString(URI_KEY)).setKey(r3.getString(KEY_KEY)).setBot(r3.getBoolean(IS_BOT_KEY)).setImportant(r3.getBoolean(IS_IMPORTANT_KEY)).build();
    L5:
        r2 = null;
        goto L7
    }

    public static Person fromPersistableBundle(PersistableBundle r0) {
        return Api22Impl.fromPersistableBundle(r0);
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if ((r4 instanceof Person) == true) goto L8;
        return false;
    L8:
        Person r5 = (Person) r4;
        String r1 = getKey();
        String r2 = r5.getKey();
        if (r1 != null) goto L23;
        if (r2 != null) goto L23;
        if (Objects.equals(Objects.toString(getName()), Objects.toString(r5.getName())) == true) goto L15;
        return false;
    L15:
        if (Objects.equals(getUri(), r5.getUri()) == true) goto L17;
        return false;
    L17:
        if (Objects.equals(Boolean.valueOf(isBot()), Boolean.valueOf(r5.isBot())) == true) goto L19;
        return false;
    L19:
        if (Objects.equals(Boolean.valueOf(isImportant()), Boolean.valueOf(r5.isImportant())) == false) goto L27;
        return true;
    L27:
        return false;
    L23:
        return Objects.equals(r1, r2);
    }
}
