package androidx.core.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";

    @Nullable
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;

    @Nullable
    String mKey;

    @Nullable
    CharSequence mName;

    @Nullable
    String mUri;

    @RequiresApi(22)
    public static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        public static Person fromPersistableBundle(PersistableBundle r5) {
            return new Builder().setName(r5.getString(Person.NAME_KEY)).setUri(r5.getString("uri")).setKey(r5.getString("key")).setBot(r5.getBoolean(Person.IS_BOT_KEY)).setImportant(r5.getBoolean(Person.IS_IMPORTANT_KEY)).build();
        }

        @DoNotInline
        public static PersistableBundle toPersistableBundle(Person r5) {
            PersistableBundle r10 = new PersistableBundle();
            CharSequence r11 = r5.mName;
            if (r11 == null) goto L5;
            String r12 = r11.toString();
        L6:
            r10.putString(Person.NAME_KEY, r12);
            r10.putString("uri", r5.mUri);
            r10.putString("key", r5.mKey);
            r10.putBoolean(Person.IS_BOT_KEY, r5.mIsBot);
            r10.putBoolean(Person.IS_IMPORTANT_KEY, r5.mIsImportant);
            return r10;
        L5:
            r12 = null;
            goto L6
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Person fromAndroidPerson(android.app.Person r5) {
            Builder r10 = new Builder().setName(r5.getName());
            if (r5.getIcon() == null) goto L5;
            IconCompat r11 = IconCompat.createFromIcon(r5.getIcon());
        L7:
            return r10.setIcon(r11).setUri(r5.getUri()).setKey(r5.getKey()).setBot(r5.isBot()).setImportant(r5.isImportant()).build();
        L5:
            r11 = null;
            goto L7
        }

        @DoNotInline
        public static android.app.Person toAndroidPerson(Person r5) {
            android.app.Person.Builder r10 = new android.app.Person.Builder().setName(r5.getName());
            if (r5.getIcon() == null) goto L5;
            Icon r11 = r5.getIcon().toIcon();
        L7:
            return r10.setIcon(r11).setUri(r5.getUri()).setKey(r5.getKey()).setBot(r5.isBot()).setImportant(r5.isImportant()).build();
        L5:
            r11 = null;
            goto L7
        }
    }

    public static class Builder {

        @Nullable
        IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;

        @Nullable
        String mKey;

        @Nullable
        CharSequence mName;

        @Nullable
        String mUri;

        public Builder() {
        }

        @NonNull
        public Person build() {
            return new Person(this);
        }

        @NonNull
        public Builder setBot(boolean r5) {
            this.mIsBot = r5;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat r5) {
            this.mIcon = r5;
            return this;
        }

        @NonNull
        public Builder setImportant(boolean r5) {
            this.mIsImportant = r5;
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String r5) {
            this.mKey = r5;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r5) {
            this.mName = r5;
            return this;
        }

        @NonNull
        public Builder setUri(@Nullable String r5) {
            this.mUri = r5;
            return this;
        }

        public Builder(Person r5) {
            this.mName = r5.mName;
            this.mIcon = r5.mIcon;
            this.mUri = r5.mUri;
            this.mKey = r5.mKey;
            this.mIsBot = r5.mIsBot;
            this.mIsImportant = r5.mIsImportant;
        }
    }

    public Person(Builder r5) {
        this.mName = r5.mName;
        this.mIcon = r5.mIcon;
        this.mUri = r5.mUri;
        this.mKey = r5.mKey;
        this.mIsBot = r5.mIsBot;
        this.mIsImportant = r5.mIsImportant;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person r5) {
        return Api28Impl.fromAndroidPerson(r5);
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle r5) {
        Bundle r10 = r5.getBundle(ICON_KEY);
        Builder r11 = new Builder().setName(r5.getCharSequence(NAME_KEY));
        if (r10 == null) goto L5;
        IconCompat r12 = IconCompat.createFromBundle(r10);
    L7:
        return r11.setIcon(r12).setUri(r5.getString("uri")).setKey(r5.getString("key")).setBot(r5.getBoolean(IS_BOT_KEY)).setImportant(r5.getBoolean(IS_IMPORTANT_KEY)).build();
    L5:
        r12 = null;
        goto L7
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle r5) {
        return Api22Impl.fromPersistableBundle(r5);
    }

    public boolean equals(@Nullable Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof Person) == true) goto L8;
        return false;
    L8:
        Person r10 = (Person) r5;
        String r11 = getKey();
        String r12 = r10.getKey();
        if (r11 != null) goto L23;
        if (r12 != null) goto L23;
        if (Objects.equals(Objects.toString(getName()), Objects.toString(r10.getName())) == true) goto L15;
        return false;
    L15:
        if (Objects.equals(getUri(), r10.getUri()) == true) goto L17;
        return false;
    L17:
        if (Boolean.valueOf(isBot()).equals(Boolean.valueOf(r10.isBot())) == true) goto L19;
        return false;
    L19:
        if (Boolean.valueOf(isImportant()).equals(Boolean.valueOf(r10.isImportant())) == false) goto L27;
        return true;
    L27:
        return false;
    L23:
        return Objects.equals(r11, r12);
    }

    @Nullable
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @Nullable
    public String getKey() {
        return this.mKey;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    @Nullable
    public String getUri() {
        return this.mUri;
    }

    public int hashCode() {
        String r5 = getKey();
        if (r5 == null) goto L7;
        return r5.hashCode();
    L7:
        return Objects.hash(new Object[]{getName(), getUri(), Boolean.valueOf(isBot()), Boolean.valueOf(isImportant())});
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String resolveToLegacyUri() {
        String r5 = this.mUri;
        if (r5 == null) goto L6;
        return r5;
    L6:
        if (this.mName != null) goto L8;
        return "";
    L8:
        return "name:" + this.mName;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        return Api28Impl.toAndroidPerson(this);
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle r5 = new Bundle();
        r5.putCharSequence(NAME_KEY, this.mName);
        IconCompat r10 = this.mIcon;
        if (r10 == null) goto L5;
        Bundle r11 = r10.toBundle();
    L6:
        r5.putBundle(ICON_KEY, r11);
        r5.putString("uri", this.mUri);
        r5.putString("key", this.mKey);
        r5.putBoolean(IS_BOT_KEY, this.mIsBot);
        r5.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return r5;
    L5:
        r11 = null;
        goto L6
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        return Api22Impl.toPersistableBundle(this);
    }
}
