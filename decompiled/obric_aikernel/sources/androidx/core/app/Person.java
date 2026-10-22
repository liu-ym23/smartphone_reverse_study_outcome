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
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Person fromPersistableBundle(PersistableBundle r10) {
            return new Builder().setName(r10.getString("name")).setUri(r10.getString(Person.URI_KEY)).setKey(r10.getString(Person.KEY_KEY)).setBot(r10.getBoolean(Person.IS_BOT_KEY)).setImportant(r10.getBoolean(Person.IS_IMPORTANT_KEY)).build();
        }

        @DoNotInline
        static PersistableBundle toPersistableBundle(Person r10) {
            PersistableBundle r11 = new PersistableBundle();
            CharSequence r12 = r10.mName;
            if (r12 == null) goto L5;
            String r13 = r12.toString();
        L6:
            r11.putString("name", r13);
            r11.putString(Person.URI_KEY, r10.mUri);
            r11.putString(Person.KEY_KEY, r10.mKey);
            r11.putBoolean(Person.IS_BOT_KEY, r10.mIsBot);
            r11.putBoolean(Person.IS_IMPORTANT_KEY, r10.mIsImportant);
            return r11;
        L5:
            r13 = null;
            goto L6
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Person fromAndroidPerson(android.app.Person r10) {
            Builder r11 = new Builder().setName(r10.getName());
            if (r10.getIcon() == null) goto L5;
            IconCompat r12 = IconCompat.createFromIcon(r10.getIcon());
        L7:
            return r11.setIcon(r12).setUri(r10.getUri()).setKey(r10.getKey()).setBot(r10.isBot()).setImportant(r10.isImportant()).build();
        L5:
            r12 = null;
            goto L7
        }

        @DoNotInline
        static android.app.Person toAndroidPerson(Person r10) {
            android.app.Person.Builder r11 = new android.app.Person.Builder().setName(r10.getName());
            if (r10.getIcon() == null) goto L5;
            Icon r12 = r10.getIcon().toIcon();
        L7:
            return r11.setIcon(r12).setUri(r10.getUri()).setKey(r10.getKey()).setBot(r10.isBot()).setImportant(r10.isImportant()).build();
        L5:
            r12 = null;
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

        Builder(Person r10) {
            this.mName = r10.mName;
            this.mIcon = r10.mIcon;
            this.mUri = r10.mUri;
            this.mKey = r10.mKey;
            this.mIsBot = r10.mIsBot;
            this.mIsImportant = r10.mIsImportant;
        }

        @NonNull
        public Person build() {
            return new Person(this);
        }

        @NonNull
        public Builder setBot(boolean r10) {
            this.mIsBot = r10;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat r10) {
            this.mIcon = r10;
            return this;
        }

        @NonNull
        public Builder setImportant(boolean r10) {
            this.mIsImportant = r10;
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String r10) {
            this.mKey = r10;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r10) {
            this.mName = r10;
            return this;
        }

        @NonNull
        public Builder setUri(@Nullable String r10) {
            this.mUri = r10;
            return this;
        }
    }

    Person(Builder r10) {
        this.mName = r10.mName;
        this.mIcon = r10.mIcon;
        this.mUri = r10.mUri;
        this.mKey = r10.mKey;
        this.mIsBot = r10.mIsBot;
        this.mIsImportant = r10.mIsImportant;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person r10) {
        return Api28Impl.fromAndroidPerson(r10);
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle r10) {
        Bundle r11 = r10.getBundle(ICON_KEY);
        Builder r12 = new Builder().setName(r10.getCharSequence("name"));
        if (r11 == null) goto L5;
        IconCompat r13 = IconCompat.createFromBundle(r11);
    L7:
        return r12.setIcon(r13).setUri(r10.getString(URI_KEY)).setKey(r10.getString(KEY_KEY)).setBot(r10.getBoolean(IS_BOT_KEY)).setImportant(r10.getBoolean(IS_IMPORTANT_KEY)).build();
    L5:
        r13 = null;
        goto L7
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle r10) {
        return Api22Impl.fromPersistableBundle(r10);
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

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String resolveToLegacyUri() {
        String r10 = this.mUri;
        if (r10 == null) goto L6;
        return r10;
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
        Bundle r10 = new Bundle();
        r10.putCharSequence("name", this.mName);
        IconCompat r11 = this.mIcon;
        if (r11 == null) goto L5;
        Bundle r12 = r11.toBundle();
    L6:
        r10.putBundle(ICON_KEY, r12);
        r10.putString(URI_KEY, this.mUri);
        r10.putString(KEY_KEY, this.mKey);
        r10.putBoolean(IS_BOT_KEY, this.mIsBot);
        r10.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return r10;
    L5:
        r12 = null;
        goto L6
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        return Api22Impl.toPersistableBundle(this);
    }
}
