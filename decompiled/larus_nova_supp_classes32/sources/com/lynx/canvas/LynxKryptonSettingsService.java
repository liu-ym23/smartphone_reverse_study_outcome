package com.lynx.canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxKryptonSettingsService extends KryptonSettingsService {
    private static final String TAG = "LynxKryptonSettingsService";

    public LynxKryptonSettingsService() {
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public boolean booleanValueForKey(String r1, boolean r2) {
        return LynxSettingsUtils.booleanValueForKey(r1, r2);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public double doubleValueForKey(String r1, double r2) {
        return LynxSettingsUtils.doubleValueForKey(r1, r2);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public int integerValueForKey(String r1, int r2) {
        return LynxSettingsUtils.integerValueForKey(r1, r2);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public Object objectValueForKey(String r1, Object r2) {
        return LynxSettingsUtils.objectValueForKey(r1, r2);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public String stringValueForKey(String r1, String r2) {
        return LynxSettingsUtils.stringValueForKey(r1, r2);
    }
}
