package plugin.abmock;

import com.bytedance.ies.abmock.ConfigItem;
import com.bytedance.ies.abmock.SaveConfigType;
import com.bytedance.ies.abmock.datacenter.plugin.BaseConfigPlugin;

/* JADX INFO: loaded from: classes8.dex */
public class ConfigPluginImpl extends BaseConfigPlugin {
    public ConfigPluginImpl() {
    }

    @Override // com.bytedance.ies.abmock.datacenter.plugin.BaseConfigPlugin
    public void addConfigStub() {
        this.configMap.put("abmock_download_monitor_sample_2", new ConfigItem(SaveConfigType.ConfigType.INT, 50, false));
        this.configMap.put("ttk_abmock_fetch_data_optimized_experiment_3", new ConfigItem(SaveConfigType.ConfigType.BOOLEAN, false, true));
    }
}
