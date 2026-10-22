package kotlin.reflect.jvm.internal.impl.platform;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimplePlatform {
    private final String platformName;
    private final TargetPlatformVersion targetPlatformVersion;

    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }

    public String toString() {
        String r10 = getTargetName();
        if (r10.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return this.platformName + " (" + r10 + ')';
    L9:
        return this.platformName;
    L5:
        r11 = false;
        goto L6
    }
}
