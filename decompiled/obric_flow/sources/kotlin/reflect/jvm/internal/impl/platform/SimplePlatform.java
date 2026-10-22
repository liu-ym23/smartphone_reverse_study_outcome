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
        String r5 = getTargetName();
        if (r5.length() <= 0) goto L6;
        return this.platformName + " (" + r5 + ')';
    L6:
        return this.platformName;
    }
}
