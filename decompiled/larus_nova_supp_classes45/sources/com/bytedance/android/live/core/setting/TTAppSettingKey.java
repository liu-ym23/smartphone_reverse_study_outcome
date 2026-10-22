package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class TTAppSettingKey<T> extends SettingKey<T> {
    @Override // com.bytedance.android.live.core.setting.SettingKey
    public T getValue() {
        return (T) SettingUtil.getValue(SettingUtil.KEY_TT_APP_SETTING, getName(), getType(), getDefaultValue());
    }

    public TTAppSettingKey(String r1, Class r2) {
        super(r1, r2);
    }

    public TTAppSettingKey(String r1, T r2) {
        super(r1, r2);
    }

    public TTAppSettingKey(String r1, Class r2, String r3) {
        super(r1, r2, r3);
    }

    public TTAppSettingKey(String r1, T r2, String r3) {
        super(r1, r2, r3);
    }

    public TTAppSettingKey(String r1, T r2, String r3, String... r4) {
        super(r1, r2, r3, r4);
    }
}
